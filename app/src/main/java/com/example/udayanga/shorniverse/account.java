package com.example.udayanga.shorniverse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class account extends AppCompatActivity {

    Button up, Lout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        up = findViewById(R.id.UpdAcc);
        Lout = findViewById(R.id.LogOut);


        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast f = Toast.makeText(getApplicationContext(),"toast done ", Toast.LENGTH_SHORT);
                //f.show();

                Intent t = new Intent(account.this, updatAcc.class);
                startActivity(t);
            }
        });

        Lout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(account.this, StartActivity.class);
                startActivity(e);
            }
        });


    }
}
