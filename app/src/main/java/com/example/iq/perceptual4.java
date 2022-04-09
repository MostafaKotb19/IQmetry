package com.example.iq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Objects;

public class perceptual4 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;

    RadioButton pq411b;
    RadioButton pq412b;
    RadioButton pq413b;
    RadioButton pq414b;
    RadioButton pq421b;
    RadioButton pq422b;
    RadioButton pq423b;
    RadioButton pq424b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_perceptual4);
        timertext = findViewById(R.id.ptimer4);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult",0);

        next = findViewById(R.id.pnext4);

        pq411b = findViewById(R.id.pq411);
        pq412b = findViewById(R.id.pq412);
        pq413b = findViewById(R.id.pq413);
        pq414b = findViewById(R.id.pq414);
        pq421b = findViewById(R.id.pq421);
        pq422b = findViewById(R.id.pq422);
        pq423b = findViewById(R.id.pq423);
        pq424b = findViewById(R.id.pq424);
        pq411b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq412b.setChecked(false);
                pq413b.setChecked(false);
                pq414b.setChecked(false);
            }
        });
        pq412b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq411b.setChecked(false);
                pq413b.setChecked(false);
                pq414b.setChecked(false);
                score++;
            }
        });
        pq413b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq411b.setChecked(false);
                pq412b.setChecked(false);
                pq414b.setChecked(false);
            }
        });
        pq414b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq411b.setChecked(false);
                pq412b.setChecked(false);
                pq413b.setChecked(false);
            }
        });
        pq421b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq422b.setChecked(false);
                pq423b.setChecked(false);
                pq424b.setChecked(false);
            }
        });
        pq422b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq421b.setChecked(false);
                pq423b.setChecked(false);
                pq424b.setChecked(false);
            }
        });
        pq423b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq421b.setChecked(false);
                pq422b.setChecked(false);
                pq424b.setChecked(false);
            }
        });
        pq424b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq421b.setChecked(false);
                pq422b.setChecked(false);
                pq423b.setChecked(false);
                score++;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score==2&&intentnumber==5){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 4);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 4);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score<=1&&intentnumber==5){
                    Intent navio = new Intent(getBaseContext(), perceptual3.class);
                    navio.putExtra("intentnumber",4);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
            }
        });
    }
    public void starttimer(){
        timer = new CountDownTimer(timeleft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleft = millisUntilFinished;
                int minutes = (int) timeleft/60000;
                int seconds = (int) timeleft%60000/1000;
                String timelefttext;
                timelefttext = "" + minutes;
                timelefttext += ":";
                if (seconds<10) timelefttext += "0";
                timelefttext += seconds;
                timertext.setText(timelefttext);
            }

            @Override
            public void onFinish() {
                if(score==2&&intentnumber==5){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 4);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 4);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score<=1&&intentnumber==5){
                    Intent navio = new Intent(getBaseContext(), perceptual3.class);
                    navio.putExtra("intentnumber",4);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}