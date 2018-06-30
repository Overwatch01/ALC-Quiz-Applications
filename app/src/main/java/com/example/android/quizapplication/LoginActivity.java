package com.example.android.quizapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class LoginActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**The code for background animation in login page**/
        RelativeLayout main = findViewById(R.id.main);
        AnimationDrawable animateDrawable = (AnimationDrawable) main.getBackground();
        animateDrawable.setEnterFadeDuration(2000);
        animateDrawable.setExitFadeDuration(4000);
        animateDrawable.start();



        /**The method that takes you to the main activity page when the login button is clicked**/
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(open);;
            }
        });

    }
}

