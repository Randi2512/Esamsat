package com.example.esamsat.info.Peraturan;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static String BASE_URL = "https://192.168.13.27/Esamsat/";
    private static Retrofit retrofit ;
    public static Api endpoint(){

        retrofit = new Retrofit.Builder()
                .baseUrl( BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create( Api.class );
    }
}