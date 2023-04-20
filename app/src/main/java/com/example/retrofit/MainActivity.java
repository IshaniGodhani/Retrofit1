package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofit.Models.Address;
import com.example.retrofit.Models.DataModel;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);
        RetrofitApicalling();

    }
    private void RetrofitApicalling () {

        Retro_Instance_Class.MyAPICalling().userData().enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response)
            {
                Log.d("aaa", "onResponse: "+response.body());
                List<DataModel> list = response.body();
                for (int i=0;i<list.size();i++)
                {
                    Log.d("bbb", "onResponse: "+list.get(i).getEmail().toString());
                    textView.append(list.get(i).getName());

                }

            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t)
            {
                Log.e("eee", "onResponse: "+t.getLocalizedMessage());
            }
        });

        Retro_Instance_Class.MyAPICalling().adressData().enqueue(new Callback<List<Address>>() {
            @Override
            public void onResponse(Call<List<Address>> call, Response<List<Address>> response) {
                Log.d("bbb", "onResponse: "+response.body());
                List<Address> list = response.body();
                for (int i=0;i<list.size();i++)
                {
                    textView.append(list.get(i).getSuite());

                }
            }

            @Override
            public void onFailure(Call<List<Address>> call, Throwable t) {

            }
        });

    }

}