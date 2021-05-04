package com.example.app_codedeconduite;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz1 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button bNext;
    int score=0;
    String RepCorrect="Je décélère";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        // Step 2 : Recuperation des ids
        rg=(RadioGroup) findViewById(R.id.radioGroup);
        bNext=(Button) findViewById(R.id.buttonquiz1);
        // Step 3 : Assoctiation Listeners
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rg.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(),"Merci de choisir une réponse S.V.P !",Toast.LENGTH_SHORT).show();
                }
                else {
                    rb=(RadioButton) findViewById(rg.getCheckedRadioButtonId());
                    //Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_SHORT).show();
                    if(rb.getText().toString().equals(RepCorrect)){
                        score+=1;
                        //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
                    }
                    Intent intent=new Intent(Quiz1.this,Quiz2.class);
                    intent.putExtra("score",score);
                    startActivity(intent);
                    //overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    overridePendingTransition(R.anim.exit,R.anim.entry); // transition entre 2 activity
                    finish(); // pour ne pas revenir en arriere
                }

            }
        });

    }
}
