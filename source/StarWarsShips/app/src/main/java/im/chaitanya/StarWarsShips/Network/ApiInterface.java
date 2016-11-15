package im.chaitanya.StarWarsShips.Network;

import im.chaitanya.StarWarsShips.Network.Models.Film;
import im.chaitanya.StarWarsShips.Network.Models.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;


public interface ApiInterface {
    /**
     *
     * @param page
     *      Provides page number
     * @return
     *      Observable that emits a single result object
     */
    @GET("starships/")
    Observable<Result> getStarShipsByPage(@Query("page") int page);

    /**
     *
     * @param url
     *      Film's url
     * @return
     *      Observable that emits a single film object
     */
    @GET
    Observable<Film> getFilmByURL(@Url String url);
}