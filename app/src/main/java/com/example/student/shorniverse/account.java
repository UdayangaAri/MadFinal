package com.example.student.shorniverse;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class account extends AppCompatActivity {

    Button up, Lout;
    TextView un, phn, email;
    DatabaseReference redRef;
    signupClass acc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        up = findViewById(R.id.UpdAcc);
        Lout = findViewById(R.id.LogOut);
        un = findViewById(R.id.accUN);
        phn = findViewById(R.id.accpn);
        email = findViewById(R.id.accEmail);

        acc = new signupClass();

        DatabaseReference redRef = FirebaseDatabase.getInstance().getReference().child("signup").child("register");
        redRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.hasChildren()){

                    un.setText(dataSnapshot.child("proName").getValue().toString());
                    phn.setText(dataSnapshot.child("phone").getValue().toString());
                    email.setText(dataSnapshot.child("email").getValue().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Source to Display",Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
