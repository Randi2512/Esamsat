package com.example.esamsat.info.SamKel.PERIODE;

import com.example.esamsat.info.SamKel.UPTD.Uptd;
import com.example.esamsat.ui.SamkelToday.samkel_Today;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("databulan.php")


    Call<periode_Samkel> getperiode_Samkel();



}
