package com.example.esamsat.info.Peraturan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.esamsat.R;

public class PeraturanpajakActivity extends AppCompatActivity {
    CardView btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peraturanpajak);



        btn1 =  findViewById(R.id.card1);
        btn2 = findViewById(R.id.card2);
        btn3 = findViewById(R.id.card3);
        btn4 = findViewById(R.id.card4);
        btn5 = findViewById(R.id.card5);
        btn6 = findViewById(R.id.card6);
        btn7 = findViewById(R.id.card7);
        btn8 = findViewById(R.id.card8);
        btn9 = findViewById(R.id.card9);
        btn10 = findViewById(R.id.card10);
        btn11 = findViewById(R.id.card11);
        btn12 = findViewById(R.id.card12);
        btn13 = findViewById(R.id.card13);
        btn14 = findViewById(R.id.card14);

        TextView marque1 = (TextView) this.findViewById(R.id.txtperaturan);
        marque1.setSelected(true);






        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1InFycimMccJQmmuLBFzF5ct0QZmVHwxg/view?usp=sharing");
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1VMeMjMUnGXrh9srVt3KOxFkgZHhdGR22/view?usp=sharing");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1xzjpA4r0Ed-eLTTMb9xOyIjDEmjduzrG/view?usp=sharing");
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1BMNjD49KMp-J3vdrNygL9IMipM2hQfJE/view?usp=sharing");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/18Hz0csp1ByMLHrK7vv6Vijkdw4VnukzW/view?usp=sharing");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1gwt0RFbIV3DfkPU02CazAyjfEt-7gYWO/view?usp=sharing");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/18ArgJjXFOzl9vPJguirqC2RGSFUqImwh/view?usp=sharing");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1V9gQO8l-D0Xjqh5_o5B7YZsewFlFkiRv/view?usp=sharing");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1f8DBUy599JaASxYrINlNdzBe-kKZlx65/view?usp=sharing");
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1tJOTkaPDUFO_gn9-9Ddi8rBlHa1Eq0gY/view?usp=sharing");
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1xqD52_H8ywZvPZqOVKt_XR86l3sWBGKr/view?usp=sharing");
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/125TrGN780uWl-opHr7GWXSYEFEzGXq5c/view?usp=sharing");
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1v70G0HLBW3K86RDXFRGKDXHvzpM3aVMP/view?usp=sharing");
            }
        });

        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1EJEIMdChpfvNhhGzA19LKqM6OczIJZHE/view?usp=sharing");
            }
        });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}