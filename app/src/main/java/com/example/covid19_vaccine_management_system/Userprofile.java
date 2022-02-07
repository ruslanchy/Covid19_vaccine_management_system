package com.example.covid19_vaccine_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Userprofile extends AppCompatActivity {
    TextView usernamebanner,useradress1,usermail1,userphone1,userage1;
    Button seeinfobtn;
   // EditText username1,userphone1,usermail1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);


        //hooks
        usernamebanner = (TextView)findViewById(R.id.tvprofilepersonname);
       // username1= (EditText)findViewById(R.id.etprofilepersonname);
        userage1=(TextView)findViewById(R.id.etuserage);
        useradress1=(TextView)findViewById(R.id.textView15);
        usermail1 = (TextView)findViewById(R.id.textView16);
        userphone1=(TextView) findViewById(R.id.textView17);
       // seeinfobtn=(Button) findViewById(R.id.exitbtnforomprofile);
      //  usermail1=(EditText)findViewById(R.id.etprofilepersonmail);

        Intent intent = getIntent();

        String user_username2 = intent.getStringExtra("name1");
        String user_userage2 = intent.getStringExtra("age1");
        String user_useradress2 = intent.getStringExtra("adress1");
        String user_usermail2 = intent.getStringExtra("email1");
        String user_userphone2 = intent.getStringExtra("number1");


        usernamebanner.setText(user_username2);
       // username1.setText(user_username2);
        userage1.setText(user_userage2);
        useradress1.setText(user_useradress2);
        usermail1.setText(user_usermail2);
        userphone1.setText(user_userphone2);



        }



}