package com.example.udayanga.shorniverse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home1 extends AppCompatActivity {

    ImageView i1, i2, i3, i4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);



        i1 = (ImageView) findViewById(R.id.buyHome);
        i2 = (ImageView)findViewById(R.id.sellHome);
        i3 = (ImageView)findViewById(R.id.cartHome);
        i4 = (ImageView)findViewById(R.id.accHome);



        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q = new Intent(Home1.this, account.class);
                startActivity(q);
            }
        });


        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w = new Intent(Home1.this, SellActiv.class);
                startActivity(w);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w = new Intent(Home1.this, cart1.class);
                startActivity(w);
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w = new Intent(Home1.this, account.class);
                startActivity(w);
            }
        });



    }
}
