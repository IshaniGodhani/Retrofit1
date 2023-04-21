package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit.Models.RegisterData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Retro_Instance_Class.MyAPICalling().userRegister("Ishani","ishani@gmail.com","123456").enqueue(new Callback<RegisterData>() {
            @Override
            public void onResponse(Call<RegisterData> call, Response<RegisterData> response) {
                Log.d("ccc", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<RegisterData> call, Throwable t) {
                Log.d("ccc", "onResponse: "+t.getLocalizedMessage());
            }
        });

    }
}