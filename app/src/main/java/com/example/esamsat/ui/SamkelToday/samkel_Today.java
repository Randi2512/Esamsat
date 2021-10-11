package com.example.esamsat.ui.SamkelToday;

import com.example.esamsat.info.Peraturan.Peraturan;

import java.util.ArrayList;

public class samkel_Today {

    public ArrayList<Result> result;

}

class Result{
    public  String kabupaten;
    public String kecamatan;
    public String tanggal;
    public String jadwal;
    public String lokasi;

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
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
