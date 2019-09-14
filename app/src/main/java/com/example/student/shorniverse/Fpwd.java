package com.example.student.shorniverse;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fpwd extends AppCompatActivity {

    Button R1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpwd);

        R1 = findViewById(R.id.reset);

        R1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(Fpwd.this, Home1.class);
                startActivity(p);

            }
        });


    }
}
