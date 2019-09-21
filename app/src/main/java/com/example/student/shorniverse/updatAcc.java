package com.example.student.shorniverse;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class updatAcc extends AppCompatActivity {

    TextView t;
    Button up,del;
    DatabaseReference redRef, upRef, dbRef;
    EditText un, email, phn;
    signup upd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updat_acc);


        t = findViewById(R.id.Update_pay);
        un = findViewById(R.id.UPaccUN);
        email = findViewById(R.id.UpaccEmail);
        phn = findViewById(R.id.UPaccpn);
        up = findViewById(R.id.UpdAcc);
        del = findViewById(R.id.DltAcc);

        upd = new signup();


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
                final DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("signup");

                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("register")){

                            try {
                                upd.setProName(un.getText().toString().trim());
                                upd.setPhone(Integer.parseInt(phn.getText().toString().trim()));
                                upd.setEmail(email.getText().toString().trim());


                                dbRef = FirebaseDatabase.getInstance().getReference().child("signup").child("register");
                                dbRef.setValue(upd);

                                Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();


                                Intent a = new Intent(updatAcc.this, account.class);
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


        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("signup");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("register")){

                            dbRef = FirebaseDatabase.getInstance().getReference().child("signup").child("register");
                            dbRef.removeValue();
                            clearcontrols();
                            Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();

                        }

                        else
                            Toast.makeText(getApplicationContext(), "No Source To Delete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(updatAcc.this, UpPayment.class);
                startActivity(o);
            }
        });



    }
    private void clearcontrols() {
        un.setText("");
        phn.setText("");
        email.setText("");

    }
}
