package com.iteso.pddm_sesion13;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iteso.pddm_sesion13.beans.User;

public class ActivityLogin extends AppCompatActivity {

    protected EditText username;
    protected EditText password;
    protected Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.activity_login_username);
        password = (EditText) findViewById(R.id.activity_login_pwd);
        signin = (Button) findViewById(R.id.activity_login_signin);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.activity_login_signin:
                User user = new User();
                user.setUsername(username.getText().toString());
                user.setPassword(password.getText().toString());
                user.savePreferences(this);

                Intent intent = new Intent(this, ActivityMain.class);
                startActivity(intent);
                finish();
                break;
        }
    }

}
