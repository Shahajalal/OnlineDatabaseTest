package com.example.shahajalal.onlinedatabasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText namee, username, userpass;
    String sname, susername, suserpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namee = findViewById(R.id.nameedittext);
        username = findViewById(R.id.usernameedittext);
        userpass = findViewById(R.id.passwordedittext);


    }

    public void userReg(View view){

        sname=namee.getText().toString();
        susername=username.getText().toString();
        suserpass=userpass.getText().toString();

        String method="register";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,sname,susername,suserpass);

    }
}
