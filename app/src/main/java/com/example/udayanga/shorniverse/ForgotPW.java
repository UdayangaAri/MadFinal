package com.example.udayanga.shorniverse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ForgotPW extends AppCompatActivity {


    Button f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pw);

        f1 = findViewById(R.id.verify);

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast t = Toast.makeText(getApplicationContext(),"Password Verified", Toast.LENGTH_SHORT);
                t.show();

                Intent l = new Intent(ForgotPW.this,Fpwd.class);
                startActivity(l);
            }
        });
    }
}
