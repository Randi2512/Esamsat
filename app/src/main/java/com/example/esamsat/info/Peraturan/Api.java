package com.example.esamsat.info.Peraturan;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("apiperaturan.php")
    Call<Peraturan> getPeraturan();

}
