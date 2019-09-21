package com.example.student.shorniverse;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    Button register;
    DatabaseReference dbref;
    signup reg;
    EditText mail, phone, pw, pro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = findViewById(R.id.CrtAcc);
        mail = findViewById(R.id.EtMail);
        phone = findViewById(R.id.EtPhn);
        pw = findViewById(R.id.NewPw);
        pro = findViewById(R.id.proName);


        reg = new signup();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbref = FirebaseDatabase.getInstance().getReference().child("signup");

                try {
                    if (TextUtils.isEmpty(mail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please Enter Email Address", Toast.LENGTH_SHORT).show();

                    else if (TextUtils.isEmpty(phone.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please Enter Phone Number", Toast.LENGTH_SHORT).show();

                    else if (TextUtils.isEmpty(pw.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please Enter a Password", Toast.LENGTH_SHORT).show();

                    else if (TextUtils.isEmpty(pro.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please Enter a Name", Toast.LENGTH_SHORT).show();

                    else {
                        reg.setEmail(mail.getText().toString().trim());
                        reg.setPhone(Integer.parseInt(phone.getText().toString().trim()));
                        reg.setPw(pw.getText().toString().trim());
                        reg.setProName(pro.getText().toString().trim());

                        dbref.child("register").setValue(reg);

                        Toast.makeText(getApplicationContext(), "Data Added", Toast.LENGTH_SHORT).show();
                        clearcontrols();

                        Intent x = new Intent(register.this, Home1.class);
                        startActivity(x);

                        Toast.makeText(getApplicationContext(), "Welcome To Shoeniverse ! ", Toast.LENGTH_SHORT).show();


                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }



    private void clearcontrols() {
        mail.setText("");
        phone.setText("");
        pw.setText("");
        pro.setText("");
    }
}
