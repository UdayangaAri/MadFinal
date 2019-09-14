package com.example.student.shorniverse;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Item extends AppCompatActivity {

    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        i1 = findViewById(R.id.AddCart);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast k = Toast.makeText(getApplicationContext(),"Added to the Cart ", Toast.LENGTH_SHORT);
                k.show();
            }
        });
    }
}
