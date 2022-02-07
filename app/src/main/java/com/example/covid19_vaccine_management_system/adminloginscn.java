package com.example.covid19_vaccine_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class adminloginscn extends AppCompatActivity {
    EditText adminname, adminpass;
    Button adminlogin;
    TextView backtomain;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminloginscn);
        //hoooks

        adminname = (EditText)findViewById(R.id.etadminname);
        adminpass = (EditText)findViewById(R.id.etadminpass);
        adminlogin = (Button)findViewById(R.id.btnadminlogin);
        backtomain= (TextView)findViewById(R.id.admintomainmenu);
        button1 = (Button)findViewById(R.id.exitbtnadminlogin);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3  = new Intent(adminloginscn.this,LoginMain.class);
                startActivity(intent3);
            }
        });


        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(adminname.getText().toString(),adminpass.getText().toString());
            }
        });
        backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(adminloginscn.this,Main_menu.class);
                startActivity(intent2);
            }
        });


    }
    private void validate(String adminname1, String adminpass1){
        if (adminname1.equals("Admin")&& adminpass1.equals("admin")) {
            Intent intent = new Intent(adminloginscn.this,adminmenu.class);
            startActivity(intent);
        }else{
            adminname.setText(null);
            adminpass.setText(null);
            Toast.makeText(adminloginscn.this,"Error login",Toast.LENGTH_SHORT).show();
        }


    }
}