package com.iteso.pddm_sesion13;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iteso.pddm_sesion13.beans.User;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = new User().getUser(ActivitySplashScreen.this);
                Intent intent;
                //user is loged
                if(user.isLogged()){
                    intent = new Intent(ActivitySplashScreen.this,ActivityMain.class);
                }else {
                    intent = new Intent(ActivitySplashScreen.this,ActivityLogin.class);
                }
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,3000);

    }

    public User loadPreferences(){
        SharedPreferences sharedPreferences =
                getSharedPreferences("com.iteso.PDDM_Sesion13.CACAHUATE", MODE_PRIVATE);
        User user = new User();
        user.setUsername(sharedPreferences.getString("USER", null));
        user.setPassword(sharedPreferences.getString("PWD", null));
        user.setLogged(sharedPreferences.getBoolean("LOGGED", false));
        sharedPreferences = null;
        return user;
    }
}
