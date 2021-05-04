package com.example.app_codedeconduite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.lzyzsd.circleprogress.DonutProgress;

public class Score extends AppCompatActivity {
    Button bLogout, bTry;
    DonutProgress donut_progress;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        donut_progress=(DonutProgress) findViewById(R.id.donut_progress);
        bLogout=(Button) findViewById(R.id.bLogout);
        bTry=(Button) findViewById(R.id.bTry);
        Intent intent=getIntent();
        score=intent.getIntExtra("score",0) ;
        donut_progress.setDonut_progress((100*score/5)+"");
        //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
        // Step 3 : Assoctiation Listeners
        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Merci de votre Participation !", Toast.LENGTH_SHORT).show(); // envoyer une notification aux utilisateurs
                finish();
            }
        });
        bTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Score.this,Quiz1.class));
            }
        });

    }
}
