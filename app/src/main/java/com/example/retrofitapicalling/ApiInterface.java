package com.example.retrofitapicalling;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/comments") //endpoints
    Call<List<UserModel>> getUsers();
}
