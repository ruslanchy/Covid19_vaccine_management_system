package com.example.covid19_vaccine_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class aboutVaccine extends AppCompatActivity {
    private Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_vaccine);
        button1 = (Button)findViewById(R.id.exitaboutbtn);
        button2 = (Button)findViewById(R.id.reviewshowbtn);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aboutVaccine.this,Main_menu.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(aboutVaccine.this,Reviews.class);
                startActivity(intent2);
            }
        });
    }
}