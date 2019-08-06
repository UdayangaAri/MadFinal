package com.example.udayanga.shorniverse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Fpwd extends AppCompatActivity {

    Button R1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpwd);

        R1 = findViewById(R.id.reset);

        Intent p = new Intent(Fpwd.this, Home1.class);
        startActivity(p);

    }
}
