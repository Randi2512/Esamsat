package com.example.esamsat.info.Pembayaran;

public class pembayaran {
    String heading;
    String detail;
    int titleImage;
    boolean visibility;



    public pembayaran(String heading, String detail, int titleImage) {
        this.heading = heading;
        this.detail = detail;
        this.titleImage = titleImage;
        this.visibility = visibility;






    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(int titleImage) {
        this.titleImage = titleImage;
    }

    public boolean isVisibility() {
        return visibility;
    }
    
    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }


}