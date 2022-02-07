package com.example.covid19_vaccine_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VaccinationUpdates extends AppCompatActivity {
    TextView fdose,sdose,vcenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination_updates);
        //hooks
        vcenter = (TextView)findViewById(R.id.vaccinecenterlocinfo);
        fdose = (TextView)findViewById(R.id.firstdoseinfo);
        sdose = (TextView)findViewById(R.id.seconddoseinfo);

        Intent intent = getIntent();

        String user_fdose = intent.getStringExtra("firstdose1");
        String user_sdose = intent.getStringExtra("seconddose1");
        String user_vcenter = intent.getStringExtra("vaccinecenter1");

        vcenter.setText(user_vcenter);
        fdose.setText(user_fdose);
        sdose.setText(user_sdose);
    }
}