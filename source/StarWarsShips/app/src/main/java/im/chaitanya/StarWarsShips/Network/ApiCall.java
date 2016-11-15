package im.chaitanya.StarWarsShips.Network;

import im.chaitanya.StarWarsShips.Network.Models.Result;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ApiCall {

    private final ApiInterface mApiInterface;

    public ApiCall(ApiInterface apiInterface) {
        mApiInterface = apiInterface;
    }

    /**
     * Recursively calls getAllStarships until the next field in the json returned by the API isn't
     * null while using the concatmap operation on the received objects.
     * @param page
     *      page number requested from the API
     * @return
     *      returns an Observable which emits a stream of {@link Result} objects.
     */
    public Observable<Result> getAllStarships(final int page) {
        return mApiInterface.getStarShipsByPage(page)
                .concatMap(new Func1<Result, Observable<Result>>() {
                    @Override
                    public Observable<Result> call(Result result) {
                        if (result.getNext() == null) {
                            return Observable.just(result);
                        }
                        return Observable.just(result).concatWith(getAllStarships(page + 1));
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
