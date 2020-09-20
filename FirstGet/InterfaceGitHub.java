package com.example.proba;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;


public interface InterfaceGitHub {
    @GET("/users/sergf81/repos")
    //Call<List<UserGitHub>> userProp(@Path("user") String user);
    Call<List<UserGitHub>> userProp();
}
