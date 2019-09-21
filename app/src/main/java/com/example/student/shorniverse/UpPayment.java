package com.example.student.shorniverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpPayment extends AppCompatActivity {

    DatabaseReference pdRef, upPPdref, DlPref;
    EditText Fname, Lname, Cvv, Ex, Cno;
    payDetails updt;
    Button upP, dlP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_payment);

        Fname = findViewById(R.id.Fnames);
        Lname = findViewById(R.id.lNames);
        Cvv = findViewById(R.id.Cvvs);
        Ex = findViewById(R.id.Exdate);
        Cno = findViewById(R.id.crdNo);
        upP = findViewById(R.id.UpPaym);
        dlP = findViewById(R.id.DltPay);


        updt = new payDetails();

        DatabaseReference pdRef = FirebaseDatabase.getInstance().getReference().child("PayDetails").child("payDetails");

        pdRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.hasChildren()){

                    Fname.setText(dataSnapshot.child("fName").getValue().toString());
                    Lname.setText(dataSnapshot.child("lName").getValue().toString());
                    Cvv.setText(dataSnapshot.child("cvv").getValue().toString());
                    Ex.setText(dataSnapshot.child("exDate").getValue().toString());
                    Cno.setText(dataSnapshot.child("cardNo").getValue().toString());

                }
                else {
                    Toast.makeText(getApplicationContext(),"No Source to Display",Toast.LENGTH_SHORT).show();
                }

        }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        upP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DatabaseReference[] upPPdref = {FirebaseDatabase.getInstance().getReference().child("PayDetails")};

                upPPdref[0].addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("payDetails")){

                            try {
                                updt.setfName(Fname.getText().toString().trim());
                                updt.setlName(Lname.getText().toString().trim());
                                updt.setExDate(Integer.parseInt(Ex.getText().toString().trim()));
                                updt.setCvv(Integer.parseInt(Cvv.getText().toString().trim()));
                                updt.setCardNo(Integer.parseInt(Cno.getText().toString().trim()));

                                upPPdref[0] = FirebaseDatabase.getInstance().getReference().child("PayDetails").child("payDetails");
                                upPPdref[0].setValue(updt);


                                Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();


                                Intent a = new Intent(UpPayment.this, Home1.class);
                                startActivity(a);
                            }
                            catch (NumberFormatException e){
                                Toast.makeText(getApplicationContext(), "InValid Data", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        dlP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference[] DlPref = {FirebaseDatabase.getInstance().getReference().child("PayDetails")};

                DlPref[0].addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChild("payDetails")){

                            DlPref[0] = FirebaseDatabase.getInstance().getReference().child("PayDetails").child("payDetails");
                            DlPref[0].removeValue();
                            clearcontrols();
                            Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }

    private void clearcontrols() {
        Fname.setText("");
        Lname.setText("");
        Cvv.setText("");
        Ex.setText("");
        Cno.setText("");

    }

}
