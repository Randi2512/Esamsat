package com.example.esamsat.api;

import com.example.esamsat.CekPajak.GetPkbResponse;
import com.example.esamsat.info.Pembayaran.pembayaran;
import com.example.esamsat.info.Peraturan.Peraturan;
import com.example.esamsat.info.SamKel.PERIODE.GetSamkelResponse;
import com.example.esamsat.info.SamKel.PERIODE.periode_Samkel;
import com.example.esamsat.info.SamKel.UPTD.Uptd;
import com.example.esamsat.ui.SamkelToday.samkel_Today;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("apiperaturan.php")
    Call<Peraturan> getPeraturan();

    @GET ("Api_pembayaran.php")
    Call<pembayaran> getcara_pembayaran();

    @GET("getdatapkb.php")
    Call<GetPkbResponse> getDataPkb(
            @Query("noKendara") String noKendara
    );



    @GET("periodesamkel.php")
    Call<periode_Samkel> getperiode_Samkel();

    @GET("getDataUPTD.php")
    Call<Uptd> getUptd();

    @GET ("getLokasiSamkel.php")
    Call<samkel_Today> getsamkel_Today();
}
