package com.example.covid19_vaccine_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Menulocation extends AppCompatActivity {
    TextView adressshow,centeraddress;
    Button showroute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menulocation);

        //hooks
        adressshow = (TextView)findViewById(R.id.tvuserloc);
        centeraddress = (TextView)findViewById(R.id.tvcenterloc);
        showroute = (Button)findViewById(R.id.routebtn);

        Intent intent = getIntent();

        String userlocation2 = intent.getStringExtra("adress2");
        String usercenterlocation2 = intent.getStringExtra("centeradress2");

        adressshow.setText(userlocation2);
        centeraddress.setText(usercenterlocation2);

        showroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sSource = adressshow.getText().toString().trim();
                String sDest = centeraddress.getText().toString().trim();
                if(sDest.equals("Not Filled")){
                    Toast.makeText(getApplicationContext(),"No designated vaccine center found",Toast.LENGTH_SHORT).show();
                }else {
                    DisplayTrack(sSource, sDest);
                }
            }
        });
    }

    private void DisplayTrack(String sSource, String sDest) {
        try{
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/"+sSource+"/"+sDest);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException e ){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }

    }
}