package im.chaitanya.StarWarsShips;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import im.chaitanya.StarWarsShips.Network.ApiCall;
import im.chaitanya.StarWarsShips.Network.Models.Film;
import im.chaitanya.StarWarsShips.Network.Models.RecyclerShip;
import im.chaitanya.StarWarsShips.Network.Models.Result;
import im.chaitanya.StarWarsShips.Network.ApiInterface;
import im.chaitanya.StarWarsShips.Network.Models.Ship;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private final Map<String, String> mAllFilmURLsMap = new HashMap<>();
    private final List<Ship> mAllShips = new ArrayList<>();
    private final List<String> mApiCallLog = new ArrayList<>();
    private ArrayList <RecyclerShip> mAllRecyclerShips = new ArrayList<>();
    @BindView(R.id.rv_ships) RecyclerView rvShips;
    @BindView(R.id.marker_progress) ProgressBar progressBar;
    private ShipsAdapter mAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = getApplicationContext();
        rvShips.setLayoutManager(new LinearLayoutManager(mContext));
        rvShips.addItemDecoration(new SimpleDividerItemDecoration(mContext));

        if (savedInstanceState != null && savedInstanceState.containsKey("key")) {
            rvShips.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            mAllRecyclerShips = savedInstanceState.getParcelableArrayList("key");
            assert mAllRecyclerShips != null;
            mAdapter = new ShipsAdapter(mContext, mAllRecyclerShips.subList(0,15));
            rvShips.setAdapter(mAdapter);
        }
        else {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://swapi.co/api/")
                    .build();

            ApiInterface starWarsAPI = retrofit.create(ApiInterface.class);
            getAndInsertStarships(starWarsAPI);
        }
    }

    /**
     * Uses concatmap operation on the Observable returned from {@link ApiCall#getAllStarships(int)}
     * to finally pass {@link Ship} objects to the observer.
     *
     * The observer saves the Ship objects in an arraylist and performs operations on the list.
     *
     * @param starWarsAPI
     *      used for initializing the ApiCall object
     */
    private void getAndInsertStarships(final ApiInterface starWarsAPI) {

        new ApiCall(starWarsAPI)
                .getAllStarships(1)
                .concatMap(new Func1<Result, Observable<Ship>>() {
                    @Override
                    public Observable<Ship> call(Result result) {
                        return Observable.from(result.getShips());
                    }
                })
                .subscribe(new Subscriber<Ship>() {
                    @Override
                    public void onCompleted() {
                        Log.d("MainActivity", "onCompleted");
                        mAllRecyclerShips = Utils.populateRecyclerShipList(mAllShips, mAllFilmURLsMap, mAllRecyclerShips);
                        mAllRecyclerShips = Utils.sortRecyclerShips(mAllRecyclerShips);
                        //Log.d("MainActivity", mAllRecyclerShips.toString());
                        rvShips.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        mAdapter = new ShipsAdapter(mContext, mAllRecyclerShips.subList(0,15));
                        rvShips.setAdapter(mAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, e.toString(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(Ship ship) {
                        //Log.d("MainActivity", "starship = " + ship.getName());
                        for (String film: ship.getFilms()) {
                            if (!mAllFilmURLsMap.containsKey(film) && !mApiCallLog.contains(film)) {
                                getFilmAndSave(starWarsAPI, film);
                                mApiCallLog.add(film);
                            }
                        }
                        mAllShips.add(ship);
                    }
                });
    }

    private void getFilmAndSave(ApiInterface starWarsAPI, String url) {
        starWarsAPI
                .getFilmByURL(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Film>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, e.toString(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(Film film) {
                        //Log.d("MainActivity", film.getTitle());
                        mAllFilmURLsMap.put(film.getUrl(), film.getTitle());
                        //Log.d("MainActivity", mAllFilmURLsMap.toString());
                    }
                });
    }

    protected void onSaveInstanceState(Bundle outState) {
        if (rvShips.getAdapter() != null)
            outState.putParcelableArrayList("key", mAllRecyclerShips);
        super.onSaveInstanceState(outState);
    }

}
