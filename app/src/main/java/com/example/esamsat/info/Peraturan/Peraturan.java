 package com.example.esamsat.info.Peraturan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.xml.transform.Result;

public class Peraturan {
    private List<Result> result;
    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result {
        private String nama,isi,url;

        @SerializedName("body")
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getIsi() {
            return isi;
        }

        public void setIsi(String isi) {
            this.isi = isi;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        @Override
        public String toString() {
            return "Result{" +
                    "nama='" + nama + '\'' +
                    "isi ='" + isi + '\'' +
                    ", url='" + url + '\'' +
                    '}';

        }

    }

}
