package com.example.esamsat.info.Pembayaran;

import java.util.ArrayList;

public class pembayaran {

    public ArrayList<Result> result;


}
class Result{

    String nama_bank;
    String detail;
    String image;
    boolean visibility;

    public String getNama_bank() {
        return nama_bank;
    }

    public void setNama_bank(String nama_bank) {
        this.nama_bank = nama_bank;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}