package com.example.covid19_vaccine_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Adminedit extends AppCompatActivity {

    EditText firstdosedate,seconddosedate,vaccinecenter;
    TextView fullname,email,age,phoneno;
    Button adminsavebtn;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminedit);
        //hooks
        reference = FirebaseDatabase.getInstance().getReference("users");
        fullname=(TextView)findViewById(R.id.textView45);
        email=(TextView)findViewById(R.id.textView46);
        age=(TextView)findViewById(R.id.textView47);
        phoneno=(TextView)findViewById(R.id.textView48);
        firstdosedate = (EditText)findViewById(R.id.editTextTextPersonName);
        seconddosedate = (EditText)findViewById(R.id.editTextTextPersonName2);
        vaccinecenter = (EditText)findViewById(R.id.editTextTextPersonName3);
        adminsavebtn = (Button)findViewById(R.id.adminsavedatabtn);
        //firstdosedate=findViewById(R.id.editTextTextPersonName);
       // seconddosedate=findViewById(R.id.textView45);
        //vaccinecenter=findViewById(R.id.textView45);
        //showalluserdata
        showAllUserData();

        adminsavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedata();
            }
        });
    }

    private void updatedata() {

        String fullname1 = fullname.getText().toString();
        String firstdosedate1= firstdosedate.getText().toString();
        String seconddosedate1 = seconddosedate.getText().toString();
        String vaccinecenter1 = vaccinecenter.getText().toString();

        reference.child(fullname1).child("firstdose").setValue(firstdosedate.getText().toString());
        reference.child(fullname1).child("seconddose").setValue(seconddosedate.getText().toString());
        reference.child(fullname1).child("vaccinecenter").setValue(vaccinecenter.getText().toString());

        Toast.makeText(this, "data updated", Toast.LENGTH_SHORT).show();
        Intent intent3 = new Intent(Adminedit.this,adminsearch.class);
        startActivity(intent3);



    }

    private void showAllUserData(){
        Intent intent1=getIntent();
        String user_fullname=intent1.getStringExtra("name");
        String user_email=intent1.getStringExtra("email");
        String user_age=intent1.getStringExtra("age");
        String user_phoneno=intent1.getStringExtra("number");
        String user_firstvaccinedate = intent1.getStringExtra("firstdose");
        String user_secondvaccinedate = intent1.getStringExtra("seconddose");
        String user_vaccinecenter = intent1.getStringExtra("vaccinecenter");
        fullname.setText(user_fullname);
        email.setText(user_email);
        age.setText(user_age);
        phoneno.setText(user_phoneno);
        firstdosedate.setText(user_firstvaccinedate);
        seconddosedate.setText(user_secondvaccinedate);
        vaccinecenter.setText(user_vaccinecenter);

    }
}