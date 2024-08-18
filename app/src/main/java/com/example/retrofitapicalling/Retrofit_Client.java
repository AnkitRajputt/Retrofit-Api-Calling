package com.example.retrofitapicalling;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Client {

    String api = "https://jsonplaceholder.typicode.com/";
    public static Retrofit_Client instance;
    ApiInterface apiInterface;

    public Retrofit_Client() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface= retrofit.create(ApiInterface.class);
    }
    public static Retrofit_Client getInstance() {
        if (instance == null) {

            instance = new Retrofit_Client();
        }
        return instance;
    }

}
