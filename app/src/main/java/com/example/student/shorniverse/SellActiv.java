package com.example.student.shorniverse;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SellActiv extends AppCompatActivity {

    Button sell, sell2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        sell = (Button)findViewById(R.id.NewAd);
        sell2 = (Button)findViewById(R.id.MyAds);

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent s1= new Intent(SellActiv.this, NewItems.class);
                startActivity(s1);
            }
        });

        sell2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent s2 = new Intent(SellActiv.this, postedAds.class);
                startActivity(s2);

            }
        });


    }
}
