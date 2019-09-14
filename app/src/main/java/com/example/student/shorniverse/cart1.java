package com.example.student.shorniverse;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cart1 extends AppCompatActivity {


    Button x1,x2,x3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart1);

        x1 = findViewById(R.id.GoToPay);

        x1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(cart1.this, Payment.class);
                startActivity(s);
            }
        });

    }
}
