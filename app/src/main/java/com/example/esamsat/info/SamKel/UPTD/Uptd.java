package com.example.esamsat.info.SamKel.UPTD;

import com.example.esamsat.info.Peraturan.Peraturan;

import java.util.ArrayList;

public class Uptd {
    public ArrayList<Result> result;
}

class Result{

    public String id;
    public String nama_uptd;
    public String alamat;
    public  String no_telp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_uptd() {
        return nama_uptd;
    }

    public void setNama_uptd(String nama_uptd) {
        this.nama_uptd = nama_uptd;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
}
