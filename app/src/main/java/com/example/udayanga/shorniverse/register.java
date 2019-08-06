package com.example.udayanga.shorniverse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class register extends AppCompatActivity {

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = findViewById(R.id.CrtAcc);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast k = Toast.makeText(getApplicationContext(),"Welcome To Shoeniverse ! ", Toast.LENGTH_SHORT);
                k.show();

                Intent x = new Intent(register.this, Home1.class);
                startActivity(x);
            }
        });
    }
}
