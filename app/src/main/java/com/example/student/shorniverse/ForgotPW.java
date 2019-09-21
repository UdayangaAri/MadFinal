package com.example.student.shorniverse;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;

public class ForgotPW extends AppCompatActivity {


    private EditText send_email, phone,fEmail;
     Button buttonb1;
    FirebaseAuth firebaseAuth;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pw);


        phone = findViewById(R.id.EtPhn);
       // fEmail=findViewById(R.id.fEmail);
        send_email = findViewById(R.id.fEmail);
        buttonb1 = findViewById(R.id.verify);
        firebaseAuth = FirebaseAuth.getInstance();
//          getSupportActionBar().setTitle("Reset Password");
//          getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ForgotPW.this, "clicked", Toast.LENGTH_SHORT).show();


                String fEmail = send_email.getText().toString().trim();

                if (fEmail.equals("")) {
                    Toast.makeText(ForgotPW.this, "Please Enter your Email", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseAuth.sendPasswordResetEmail(fEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(ForgotPW.this, "Password Reset Email Sent", Toast.LENGTH_SHORT).show();
                                finish();
                                Intent i = new Intent(ForgotPW.this, Home1.class);
                                startActivity(i);

                            } else {
                                String error = task.getException().getMessage();
                                Toast.makeText(ForgotPW.this, "Error in sending the password reset", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }

            }
        });
    }
}

