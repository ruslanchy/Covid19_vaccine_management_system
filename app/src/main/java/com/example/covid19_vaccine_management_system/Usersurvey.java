package com.example.covid19_vaccine_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Usersurvey extends AppCompatActivity {
   // private Button buttonexit;
    private Button buttonsubmit;
    private Button seereviewbtn;
    EditText survname,survage, survfirstdose, survseconddose;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_sersurvey);

       // seereviewbtn=(Button) findViewById(R.id.button4);
        //buttonexit = (Button) findViewById(R.id.surveyexitbtn);
        buttonsubmit = (Button) findViewById(R.id.surveysubmitbtn);
        survname=findViewById(R.id.etsurveyname);
        survage = findViewById(R.id.etsurveyage);
        survfirstdose = findViewById(R.id.etsurveyfirstdose);
        survseconddose = findViewById(R.id.etsurveyseconddose);



        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
//               DatabaseReference reference = rootNode.getReference("survey");
                String name=survname.getText().toString();
                String age = survage.getText().toString();

                String servfirst = survfirstdose.getText().toString().trim();
                String servsecond = survseconddose.getText().toString();
                surveyhelperclass helperclass = new surveyhelperclass(name,age, servfirst, servsecond);
//                reference.child(name).setValue(helperclass);

                rootNode.getInstance().getReference("survey").child(name).setValue(helperclass);
            }
        });
    }

}

   /* public void saveservdb(){
        if(!validateservage() | !validateservfirstdose() | !validateservseconddose()){
            return;
        }
        rootNode=FirebaseDatabase.getInstance();
        reference =rootNode.getReference("survey");
        FirebaseAuth firebaseAuth;

        //getting values

        String surveyinputage = survage.getText().toString();
        String surveyinputfirstdose = survfirstdose.getText().toString();
        String surveyinputseconddose = survseconddose.getText().toString();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(surveyinputseconddose,surveyinputfirstdose).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    surveyhelperclass survhelp = new surveyhelperclass(surveyinputage,surveyinputfirstdose,surveyinputseconddose);
                        rootNode.getInstance().getReference("survey").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(survhelp).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Intent intent = new Intent(Usersurvey.this,Maindashboard.class);
                                startActivity(intent);
                                Toast.makeText(Usersurvey.this,"Survey Complete!!!",Toast.LENGTH_SHORT).show();
                                surveyhelperclass survhelp = new surveyhelperclass(surveyinputage,surveyinputfirstdose,surveyinputseconddose);
                                reference.child(surveyinputage).setValue(survhelp);
                            }
                        });
                }else{

                }
            }
        });
        Intent intent = new Intent(Usersurvey.this,Maindashboard.class);
        startActivity(intent);
        Toast.makeText(Usersurvey.this,"Survey complete!!!",Toast.LENGTH_SHORT).show();
        surveyhelperclass survhelp = new surveyhelperclass(surveyinputage,surveyinputfirstdose,surveyinputseconddose);
        reference.child(surveyinputage).setValue(survhelp);

    }



    private boolean validateservage() {
        String val = survage.getText().toString().trim();
        if (val.isEmpty()) {
            survage.setError("Field cannot be empty");
            return false;
        } else {
            survage.setError(null);
            // Signupusername.setErrorEnabled(false);
            return true;

        }

    }
    private boolean validateservfirstdose() {
        String val = survfirstdose.getText().toString().trim();
        if (val.isEmpty()) {
            survfirstdose.setError("Field cannot be empty");
            return false;
        } else {
            survfirstdose.setError(null);
            // Signupusername.setErrorEnabled(false);
            return true;

        }

    }
    private boolean validateservseconddose() {
        String val = survseconddose.getText().toString().trim();
        if (val.isEmpty()) {
            survseconddose.setError("Field cannot be empty");
            return false;
        } else {
            survseconddose.setError(null);
            // Signupusername.setErrorEnabled(false);
            return true;

        }

    }

}*/