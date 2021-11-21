package com.example.esamsat.info.SamKel.PERIODE;



import java.util.ArrayList;

public class periode_Samkel extends ArrayList<Result> {

    public ArrayList<Result> result;
}

class Result{
    public  String nama_uptd;
    public String kecamatan;
    public String tanggal;
    public String jadwal;
    public String lokasi;

    public String getNama_uptd() {
        return nama_uptd;
    }

    public void setNama_uptd(String nama_uptd) {
        this.nama_uptd = nama_uptd;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}