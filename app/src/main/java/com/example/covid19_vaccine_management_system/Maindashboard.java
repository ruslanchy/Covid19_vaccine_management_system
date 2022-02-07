package com.example.covid19_vaccine_management_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Maindashboard extends AppCompatActivity {
    CardView carduserprofile;
    CardView carduserlocation;
    CardView carduserschedule;
    CardView cardusersurvey;
    CardView cardlogout;
    CardView cardappabout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindashboard);

        //hooks

        carduserprofile = (CardView)findViewById(R.id.cardprofile);
        carduserlocation = (CardView)findViewById(R.id.cardlocation);
        carduserschedule = (CardView)findViewById(R.id.cardschedule);
        cardusersurvey = (CardView)findViewById(R.id.cardsurvey);
        cardappabout = (CardView)findViewById(R.id.cardabout);
        cardlogout = (CardView)findViewById(R.id.cardlogout);

        //get data from db

        carduserschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String user_firstdose1=intent.getStringExtra("firstdose");
                String user_seconddose1 = intent.getStringExtra("seconddose");
                String user_vaccinecenter1 = intent.getStringExtra("vaccinecenter");
                Intent intent60 =new Intent(Maindashboard.this, VaccinationUpdates.class);

                intent60.putExtra("firstdose1",user_firstdose1);
                intent60.putExtra("seconddose1",user_seconddose1);
                intent60.putExtra("vaccinecenter1",user_vaccinecenter1);
                startActivity(intent60);

            }
        });
        cardappabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent4 = new Intent(Maindashboard.this,Aboutapp.class);

                startActivity(intent4);
            }
        });


        cardusersurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(Maindashboard.this , Usersurvey.class);
                startActivity(intent5);
            }
        });


        carduserprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();

                String user_username = intent.getStringExtra("name");
                String user_userage = intent.getStringExtra("age");
                String user_useradress = intent.getStringExtra("adress");
                String user_usermail = intent.getStringExtra("email");
                String user_userphone = intent.getStringExtra("number");
                Intent intent2 = new Intent(Maindashboard.this,Userprofile.class);
                intent2.putExtra("name1",user_username);
                intent2.putExtra("age1",user_userage);
                intent2.putExtra("adress1",user_useradress);
                intent2.putExtra("email1",user_usermail);
                intent2.putExtra("number1",user_userphone);
                startActivity(intent2);
            }
        });

        carduserlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String location_adress = intent.getStringExtra("adress");
                String center_adress = intent.getStringExtra("vaccinecenter");
                Intent intent3 = new Intent(Maindashboard.this , Menulocation.class);
                intent3.putExtra("centeradress2",center_adress);
                intent3.putExtra("adress2",location_adress);
                startActivity(intent3);
            }
        });



        cardlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Maindashboard.this,LoginMain.class);
                startActivity(intent);
            }
        });

        

    }


}