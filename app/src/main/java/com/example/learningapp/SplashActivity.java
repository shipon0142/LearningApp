package com.example.learningapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learningapp.firebase.FirebaseManager;
import com.example.learningapp.model.User;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Thread timer= new Thread()
        {
            public void run()
            {
                try
                {
                    //Display for 3 seconds
                    sleep(3000);
                }
                catch (InterruptedException e)
                {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                finally
                {
                    //Goes to Activity  StartingPoint.java(STARTINGPOINT)


                    if(new FirebaseManager().getCurrentUser()!=null) {
                        new FirebaseManager().getMyUserInfo(new FirebaseManager().getCurrentUser().getEmail(),new FirebaseManager.RetriveUserListener() {
                            @Override
                            public void getUser(User user) {
                                MainActivity.LOGGED_IN_USER=user;
                                Intent openstartingpoint = new Intent(SplashActivity.this, MainActivity.class);
                                startActivity(openstartingpoint);
                                finish();
                            }
                        });

                    }else {
                        Intent openstartingpoint = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(openstartingpoint);
                        finish();
                    }
                }
            }
        };
        timer.start();
    }
}