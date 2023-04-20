package com.example.retrofit;

import com.example.retrofit.Models.Address;
import com.example.retrofit.Models.Company;
import com.example.retrofit.Models.DataModel;
import com.example.retrofit.Models.PostDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retro_Interface
{
    @GET("users")
    Call<List<DataModel>> userData();
    @GET("adress")
    Call<List<Address>> adressData();
    @GET("company")
    Call<List<Company>> companyData();
    @GET("users")
    Call<List<PostDataModel>> postData();
}
