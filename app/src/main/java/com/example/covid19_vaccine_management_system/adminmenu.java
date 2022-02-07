package com.example.covid19_vaccine_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminmenu extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmenu);
        //hooks

        button1 = (Button)findViewById(R.id.showdatabtn);
        button2 = (Button)findViewById(R.id.adminsearchgobtn);
        button3 = (Button)findViewById(R.id.adminlogoutbtn);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(adminmenu.this , adminloginscn.class);
                startActivity(intent3);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(adminmenu.this, adminsearch.class);
                startActivity(intent2);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminmenu.this,showdata.class);
                startActivity(intent);
            }
        });
    }
}