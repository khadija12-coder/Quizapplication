package com.example.app_codedeconduite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz2 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button bNext;
    int score;
    String RepCorrect="de la proximité de la forêt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        rg=(RadioGroup) findViewById(R.id.radioGroup);
        bNext=(Button) findViewById(R.id.buttonquiz2);
        Intent intent=getIntent();
        score=intent.getIntExtra("score",0) ;
        //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb=(RadioButton) findViewById(rg.getCheckedRadioButtonId());
                if(rg.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(),"Merci de choisir une réponse S.V.P !",Toast.LENGTH_SHORT).show();
                }
                else {
                    //Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_SHORT).show();
                    if(rb.getText().toString().equals(RepCorrect)){
                        score+=1;
                        //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
                    }
                    Intent intent=new Intent(Quiz2.this,Score.class);
                    intent.putExtra("score",score);
                    startActivity(intent);
                    //overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    overridePendingTransition(R.anim.exit,R.anim.entry);
                    finish();
                }

            }
        });

    }
}



