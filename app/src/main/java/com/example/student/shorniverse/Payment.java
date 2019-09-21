package com.example.student.shorniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Payment extends AppCompatActivity {

    Button pay;
    EditText fname, lname, cvv, ex, cno;
    payDetails pd1;
    DatabaseReference pdref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        pay = findViewById(R.id.Pay);
        fname = findViewById(R.id.Fname);
        lname = findViewById(R.id.Lname);
        cvv = findViewById(R.id.Cvv);
        ex = findViewById(R.id.ExpDate);
        cno = findViewById(R.id.CardNo);

        pd1 = new payDetails();


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                pdref = FirebaseDatabase.getInstance().getReference().child("PayDetails");


                try {
                    if (TextUtils.isEmpty(fname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please Enter First Name", Toast.LENGTH_SHORT).show();

                    else if (TextUtils.isEmpty(lname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please Enter Last Name", Toast.LENGTH_SHORT).show();

                    else if (TextUtils.isEmpty(cno.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please Enter Card Number", Toast.LENGTH_SHORT).show();

                    else if (TextUtils.isEmpty(cvv.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please Enter CVV", Toast.LENGTH_SHORT).show();

                    else if (TextUtils.isEmpty(ex.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please Enter Expire Date", Toast.LENGTH_SHORT).show();

                    else {

                        pd1.setfName(fname.getText().toString().trim());
                        pd1.setCardNo(Integer.parseInt(cno.getText().toString().trim()));
                        pd1.setlName(lname.getText().toString().trim());
                        pd1.setCvv(Integer.parseInt(cvv.getText().toString().trim()));
                        pd1.setExDate(Integer.parseInt(ex.getText().toString().trim()));

                        pdref.child("payDetails").setValue(pd1);

                        clearcontrols();

                        Intent x = new Intent(Payment.this, Home1.class);
                        startActivity(x);

                        Toast.makeText(getApplicationContext(), "Payment Is Processing ", Toast.LENGTH_SHORT).show();


                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }




            }
        });
}
    private void clearcontrols() {
        fname.setText("");
        lname.setText("");
        cvv.setText("");
        ex.setText("");
        cno.setText("");

    }
}
