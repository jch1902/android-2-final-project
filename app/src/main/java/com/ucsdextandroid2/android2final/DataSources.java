package com.ucsdextandroid2.android2final;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import java.util.Collections;
import java.util.List;

public class DataSources{
    public static DataSources instance;
    private DataAPI dataAPI;

    private DataSources(){
        Gson gson = new GsonBuilder().create();

        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.level(HttpLoggingInterceptor.Level.BODY);

        this.dataAPI = new Retrofit.Builder()
                .baseUrl("https://api.mercedes-benz.com/tryout/vehicle_images/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new OkHttpClient.Builder().addInterceptor(logger).build())
                .build()
                .create(DataAPI.class);
    }
    public static DataSources getInstance(){
        if(instance == null)
            instance = new DataSources();

        return instance;
    }
    public void getCars (Callback<List<Car>> callback){
        dataAPI.getCars().enqueue(new retrofit2.Callback<carHolder>(){
            @Override
            public void onResponse(Call<carHolder> call, Response<carHolder> response) {
                if(response.isSuccessful())
                    callback.onDataFetched(response.body().getCars());
                else
                    callback.onDataFetched(Collections.emptyList());
            }

            @Override
            public void onFailure(Call<carHolder> call, Throwable t) {
                callback.onDataFetched(Collections.emptyList());
            }
        });
    }
    public interface Callback<T>{
        void onDataFetched(T data);
    }
    private interface DataAPI{
        Call<carHolder> getCars();
    }
}
