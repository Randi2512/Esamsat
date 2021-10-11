package com.example.esamsat.ui.SamkelToday;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET ("getLokasiSamkel.php")
    Call<samkel_Today> getsamkel_Today();

}
