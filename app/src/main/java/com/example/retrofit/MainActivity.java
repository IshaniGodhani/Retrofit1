package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofit.Models.Address;
import com.example.retrofit.Models.DataModel;
import com.example.retrofit.Models.PostDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    RecyclerView recyclerView1, recyclerView2;
    String api = "https://jsonplaceholder.typicode.com";
    RecyclerAdapter_post recyclerAdapter_post;
    RecyclerAdapter_user recyclerAdapter_user;
    List<PostDataModel> postdatalist=new ArrayList<>();
    List<DataModel> dataModelList=new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       recyclerView1=findViewById(R.id.recyclerview1);
       recyclerView2=findViewById(R.id.recyclerview2);
        RetrofitApicalling();

    }
    private void RetrofitApicalling () {
        Retro_Instance_Class.MyAPICalling().postData().enqueue(new  Callback<List<PostDataModel>>() {
            @Override
            public void onResponse(Call<List<PostDataModel>> call, Response<List<PostDataModel>> response) {
                Log.d("bbb", "onResponse: "+response.body());
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(api)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Retro_Interface retro_interface=retrofit.create(Retro_Interface.class);
                postdatalist=response.body();

               recyclerAdapter_post= new RecyclerAdapter_post(MainActivity.this,postdatalist);
               LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
               //linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
               recyclerView2.setLayoutManager(linearLayoutManager);
               recyclerView2.setAdapter(recyclerAdapter_post);
            }

            @Override
            public void onFailure(Call<List<PostDataModel>> call, Throwable t) {

            }
        });

        Retro_Instance_Class.MyAPICalling().userData().enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response)
            {
                Log.d("aaa", "onResponse: "+response.body());
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(api)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Retro_Interface retro_interface=retrofit.create(Retro_Interface.class);
                dataModelList=response.body();
                recyclerAdapter_user= new RecyclerAdapter_user(MainActivity.this,dataModelList);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
               // linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerView1.setLayoutManager(linearLayoutManager);
                recyclerView1.setAdapter(recyclerAdapter_user);

            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t)
            {
                Log.e("eee", "onResponse: "+t.getLocalizedMessage());
            }
        });



    }

}