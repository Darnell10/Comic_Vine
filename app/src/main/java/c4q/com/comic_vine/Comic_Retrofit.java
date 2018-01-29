package c4q.com.comic_vine;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by D on 1/27/18.
 */

public class Comic_Retrofit implements Callback<Comic_Model> {

    private static final String TAG = "Comic?";

    private Comic_Service comic_service;


    public void comic_Call() {
    }

    public void start() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://comicvine.gamespot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        comic_service = retrofit.create(Comic_Service.class);
        Call<Comic_Model> call = comic_service.getComic("batman");
        call.enqueue(this);

    }



    @Override
    public void onResponse(Call<Comic_Model> call, Response<Comic_Model> response) {
        if (response.body() ==null){
            Log.d("onResponse: ", response.body().toString());
        } else {

        }

    }

    @Override
    public void onFailure(Call<Comic_Model> call, Throwable t) {
        Log.d(TAG, "What universe is this?" + toString());
        t.printStackTrace();
    }



}

