package com.example.retrofitapicalling;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMain;
    List<UserModel> userModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rvMain= findViewById(R.id.rcvMain);
        rvMain.setLayoutManager(new LinearLayoutManager(this));

        //Call Retrofit class
        Retrofit_Client.getInstance().apiInterface.getUsers().enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                userModels= response.body();
                rvMain.setAdapter(new UserAdapter(MainActivity.this, userModels));
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.e("Api", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}
//Change 1 git