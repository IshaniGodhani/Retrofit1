package com.example.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro_Instance_Class
{
    public static Retro_Interface MyAPICalling()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ishaniecommerce.000webhostapp.com/sitePages/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Retro_Interface.class);
    }
}
