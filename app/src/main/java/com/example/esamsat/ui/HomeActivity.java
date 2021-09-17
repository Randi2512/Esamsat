package com.example.esamsat.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.esamsat.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


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