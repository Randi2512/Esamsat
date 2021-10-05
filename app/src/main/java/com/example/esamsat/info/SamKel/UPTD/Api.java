package com.example.esamsat.info.SamKel.UPTD;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("getDataUPTD.php")


    Call<Uptd> getUptd();
}
