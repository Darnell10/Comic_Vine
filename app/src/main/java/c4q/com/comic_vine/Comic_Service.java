package c4q.com.comic_vine;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by D on 1/27/18.
 */

public interface Comic_Service {

    //https://comicvine.gamespot.com/api/search/?api_key=fe4712fe36a7a1ddde3025bdba123657124dcb09&format=json&query=justice%league

    //String api_key ="fe4712fe36a7a1ddde3025bdba123657124dcb09";

    @GET("/api/search/?api_key=fe4712fe36a7a1ddde3025bdba123657124dcb09&format=json")
    Call<Comic_Model> getInfo(@Query("query") String query);
}
