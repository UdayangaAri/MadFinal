package com.example.student.shorniverse;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class updatAcc extends AppCompatActivity {

    TextView t;
    DatabaseReference redRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updat_acc);


        t = findViewById(R.id.Update_pay);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(updatAcc.this, UpPayment.class);
                startActivity(o);
            }
        });



    }
}
