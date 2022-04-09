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

public class verbal5 extends AppCompatActivity {
    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;

    RadioButton vq511b;
    RadioButton vq512b;
    RadioButton vq513b;
    RadioButton vq514b;
    RadioButton vq521b;
    RadioButton vq522b;
    RadioButton vq523b;
    RadioButton vq524b;
    RadioButton vq531b;
    RadioButton vq532b;
    RadioButton vq533b;
    RadioButton vq534b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_verbal5);
        timertext = findViewById(R.id.vtimer5);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");

        next = findViewById(R.id.vnext5);

        vq511b = findViewById(R.id.vq511);
        vq512b = findViewById(R.id.vq512);
        vq513b = findViewById(R.id.vq513);
        vq514b = findViewById(R.id.vq514);
        vq521b = findViewById(R.id.vq521);
        vq522b = findViewById(R.id.vq522);
        vq523b = findViewById(R.id.vq523);
        vq524b = findViewById(R.id.vq524);
        vq531b = findViewById(R.id.vq531);
        vq532b = findViewById(R.id.vq532);
        vq533b = findViewById(R.id.vq533);
        vq534b = findViewById(R.id.vq534);
        vq511b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq512b.setChecked(false);
                vq513b.setChecked(false);
                vq514b.setChecked(false);
            }
        });
        vq512b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq511b.setChecked(false);
                vq513b.setChecked(false);
                vq514b.setChecked(false);
                score++;
            }
        });
        vq513b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq511b.setChecked(false);
                vq512b.setChecked(false);
                vq514b.setChecked(false);
            }
        });
        vq514b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq511b.setChecked(false);
                vq512b.setChecked(false);
                vq513b.setChecked(false);
            }
        });
        vq521b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq522b.setChecked(false);
                vq523b.setChecked(false);
                vq524b.setChecked(false);
            }
        });
        vq522b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq521b.setChecked(false);
                vq523b.setChecked(false);
                vq524b.setChecked(false);
            }
        });
        vq523b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq521b.setChecked(false);
                vq522b.setChecked(false);
                vq524b.setChecked(false);
            }
        });
        vq524b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq521b.setChecked(false);
                vq522b.setChecked(false);
                vq523b.setChecked(false);
                score++;
            }
        });
        vq531b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vq532b.isChecked()){
                    vq533b.setChecked(false);
                    vq534b.setChecked(false);
                }
                else if(vq533b.isChecked()){
                    vq532b.setChecked(false);
                    vq534b.setChecked(false);
                }
                else if(vq534b.isChecked()){
                    vq532b.setChecked(false);
                    vq533b.setChecked(false);
                    score++;
                }
            }
        });
        vq532b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vq531b.isChecked()){
                    vq533b.setChecked(false);
                    vq534b.setChecked(false);
                }
                else if(vq533b.isChecked()){
                    vq531b.setChecked(false);
                    vq534b.setChecked(false);
                }
                else if(vq534b.isChecked()){
                    vq531b.setChecked(false);
                    vq533b.setChecked(false);
                }
            }
        });
        vq533b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vq531b.isChecked()){
                    vq532b.setChecked(false);
                    vq534b.setChecked(false);
                }
                else if(vq532b.isChecked()){
                    vq531b.setChecked(false);
                    vq534b.setChecked(false);
                }
                else if(vq534b.isChecked()){
                    vq531b.setChecked(false);
                    vq532b.setChecked(false);
                }
            }
        });
        vq534b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vq531b.isChecked()){
                    vq532b.setChecked(false);
                    vq533b.setChecked(false);
                    score++;
                }
                else if(vq532b.isChecked()){
                    vq531b.setChecked(false);
                    vq533b.setChecked(false);
                }
                else if(vq533b.isChecked()){
                    vq531b.setChecked(false);
                    vq532b.setChecked(false);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score>=2&&intentnumber==6){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 5);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 5);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if((score>=2&&intentnumber==1)||(score>=2&&intentnumber==2)){
                    Intent navio = new Intent(getBaseContext(), verbal8.class);
                    navio.putExtra("intentnumber",5);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if((score<2&&intentnumber==6)||(score<2&&intentnumber==1)||(score<2&&intentnumber==2)){
                    Intent navio = new Intent(getBaseContext(), verbal4.class);
                    navio.putExtra("intentnumber",5);
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
                if(score>=2&&intentnumber==6){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 5);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 5);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if((score>=2&&intentnumber==1)||(score>=2&&intentnumber==2)){
                    Intent navio = new Intent(getBaseContext(), verbal8.class);
                    navio.putExtra("intentnumber",5);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if((score<2&&intentnumber==6)||(score<2&&intentnumber==1)||(score<2&&intentnumber==2)){
                    Intent navio = new Intent(getBaseContext(), verbal4.class);
                    navio.putExtra("intentnumber",5);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}