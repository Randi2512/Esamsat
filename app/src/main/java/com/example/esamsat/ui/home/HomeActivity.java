package com.example.esamsat.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.esamsat.R;

import com.example.esamsat.info.CekPajakActivity;
import com.example.esamsat.info.Pembayaran.PembayaranActivity;
import com.example.esamsat.info.Pengaduan;
import com.example.esamsat.info.Peraturan.PeraturanpajakActivity;
import com.example.esamsat.info.SamKel.UPTD.SamsatKeliling;
import com.example.esamsat.info.faq.faq;
import com.example.esamsat.ui.InfoActivity;
import com.example.esamsat.ui.GIS.MapsActivity;
import com.example.esamsat.ui.MONITOR.Monitoring;
import com.example.esamsat.ui.SamkelToday.SamkelToday;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ImageView img1, img2, img3, img4, img5,img6;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SliderView sliderView=findViewById(R.id.slider);


        List<Integer> images=new ArrayList<>();
        images.add(R.drawable.slide1);
        images.add(R.drawable.slide2);
        images.add(R.drawable.slide3);
        images.add(R.drawable.pajak1);
        images.add(R.drawable.pajak2);
        images.add(R.drawable.pajak3);

        AdapterSlider adapterSlider=new AdapterSlider(images);
        sliderView.setSliderAdapter(adapterSlider);
        sliderView.setAutoCycle(true);
        sliderView.setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        CardView cardView = findViewById(R.id.cardSlide);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.kompas.com/tag/Pajak-Kendaraan-Bermotor";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        TextView marque1 = (TextView) this.findViewById(R.id.sliding_text_marquee);
        marque1.setSelected(true);






        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CekPajakActivity.class);
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SamsatKeliling.class);
                startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {    
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PembayaranActivity.class);
                startActivity(intent);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Pengaduan.class);
                startActivity(intent);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PeraturanpajakActivity.class);
                startActivity(intent);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, faq.class);
                startActivity(intent);
            }
        });
/**
 List<SlideModel> slideModels = new ArrayList<>();
 slideModels.add(new SlideModel("https://www.google.com/search?q=wajib+bayar+pajak&sxsrf=ALeKk00zpqtNVt_lcx7Xn_xuWbrmqpjavQ:1628474572552&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjqs7DD7KLyAhWUA3IKHW5hDU0Q_AUoAXoECAEQAw&biw=1366&bih=600#imgrc=Vk5o02ZMVqsPeM","1 image"));
 slideModels.add(new SlideModel("https://www.google.com/search?q=wajib+pajak+adalah&tbm=isch&sxsrf=ALeKk01B2qm6eC7P8K3ziqTNs74wcI-KNA:1629694771340&source=lnms&sa=X&ved=2ahUKEwj0h8CPrsbyAhWC7XMBHY4aBYkQ_AUoAnoECAcQBA&biw=1366&bih=657&dpr=1#imgrc=ezzeKHDzfSapwM&imgdii=p3Bx_5MV352bBM","2 image"));
 imageSlider.setImageList(slideModels,true);
 */

        BottomNavigationView bottomNavigationView  = findViewById(R.id.nav_view);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem){
                switch (menuitem.getItemId()){
                    case R.id.home:
                        return true;

                    case R.id.Samkel:
                        startActivity(new Intent(getApplicationContext()
                        , SamkelToday.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.info:
                        startActivity(new Intent(getApplicationContext()
                                , InfoActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.lokasi:
                        startActivity(new Intent(getApplicationContext()
                                , MapsActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }


                return false;
            }
        });

    }


}