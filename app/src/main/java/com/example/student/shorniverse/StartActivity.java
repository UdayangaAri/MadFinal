package com.example.student.shorniverse;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    Button SignIn;
    TextView member, register,shoes, welcome;
    Animation top, top2, top3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        SignIn  = findViewById(R.id.SignIn);
        member = findViewById(R.id.member);
        register = findViewById(R.id.register);
        shoes = findViewById(R.id.shoes);
        welcome = findViewById(R.id.welcome);

        top = AnimationUtils.loadAnimation(this, R.anim.top);
        top2 = AnimationUtils.loadAnimation(this, R.anim.top2);
        top3 = AnimationUtils.loadAnimation(this, R.anim.top3);

        SignIn.setAnimation(top2);
        member.setAnimation(top3);
        register.setAnimation(top3);
        shoes.setAnimation(top);
        welcome.setAnimation(top);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(StartActivity.this,register.class);
                startActivity(m);
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, login.class);
                startActivity(i);
            }
        });

    }
}
