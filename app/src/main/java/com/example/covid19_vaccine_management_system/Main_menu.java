package com.example.covid19_vaccine_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_menu extends AppCompatActivity {
        private Button button;
        private Button button2;
        private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        button=(Button) findViewById(R.id.Loginbtn);
        button2= (Button)findViewById(R.id.Signupbtn);
        button3 = (Button)findViewById(R.id.aboutvaccinebtn);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutvaccine();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    private void openAboutvaccine() {
        Intent intent4 = new Intent(Main_menu.this, aboutVaccine.class);
        startActivity(intent4);
    }

    public void openLogin(){
        Intent intent = new Intent(Main_menu.this,LoginMain.class);
        startActivity(intent);
    }
    public void openSignup(){
        Intent intent2 = new Intent(Main_menu.this,Signupmain.class);
        startActivity(intent2);
    }
}