package com.example.esamsat.info.SamKel.PERIODE;



import java.util.ArrayList;

public class periode_Samkel {

    public ArrayList<Result> result;
}

class Result{
    public String id;
    public String bulan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

}