package com.example.retrofit;

import com.example.retrofit.Models.Address;
import com.example.retrofit.Models.Company;
import com.example.retrofit.Models.DataModel;
import com.example.retrofit.Models.PostDataModel;
import com.example.retrofit.Models.RegisterData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Retro_Interface
{
    @GET("users")
    Call<List<DataModel>> userData();

    @GET("posts")
    Call<List<PostDataModel>> postData();
    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterData> userRegister(@Field("name") String name, @Field("email") String email,@Field("password")String password);
}
