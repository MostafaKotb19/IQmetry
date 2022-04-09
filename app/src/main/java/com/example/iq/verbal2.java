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

public class verbal2 extends AppCompatActivity {
    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;

    RadioButton vq211b;
    RadioButton vq212b;
    RadioButton vq213b;
    RadioButton vq214b;
    RadioButton vq221b;
    RadioButton vq222b;
    RadioButton vq223b;
    RadioButton vq224b;
    RadioButton vq231b;
    RadioButton vq232b;
    RadioButton vq233b;
    RadioButton vq234b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_verbal2);
        timertext = findViewById(R.id.vtimer2);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");

        next = findViewById(R.id.vnext2);

        vq211b = findViewById(R.id.vq211);
        vq212b = findViewById(R.id.vq212);
        vq213b = findViewById(R.id.vq213);
        vq214b = findViewById(R.id.vq214);
        vq221b = findViewById(R.id.vq221);
        vq222b = findViewById(R.id.vq222);
        vq223b = findViewById(R.id.vq223);
        vq224b = findViewById(R.id.vq224);
        vq231b = findViewById(R.id.vq231);
        vq232b = findViewById(R.id.vq232);
        vq233b = findViewById(R.id.vq233);
        vq234b = findViewById(R.id.vq234);
        vq211b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq212b.setChecked(false);
                vq213b.setChecked(false);
                vq214b.setChecked(false);
            }
        });
        vq212b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq211b.setChecked(false);
                vq213b.setChecked(false);
                vq214b.setChecked(false);
                score++;
            }
        });
        vq213b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq211b.setChecked(false);
                vq212b.setChecked(false);
                vq214b.setChecked(false);
            }
        });
        vq214b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq211b.setChecked(false);
                vq212b.setChecked(false);
                vq213b.setChecked(false);
            }
        });
        vq221b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq222b.setChecked(false);
                vq223b.setChecked(false);
                vq224b.setChecked(false);
                score++;
            }
        });
        vq222b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq221b.setChecked(false);
                vq223b.setChecked(false);
                vq224b.setChecked(false);
            }
        });
        vq223b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq221b.setChecked(false);
                vq222b.setChecked(false);
                vq224b.setChecked(false);
            }
        });
        vq224b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq221b.setChecked(false);
                vq222b.setChecked(false);
                vq223b.setChecked(false);
            }
        });
        vq231b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq232b.setChecked(false);
                vq233b.setChecked(false);
                vq234b.setChecked(false);
            }
        });
        vq232b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq231b.setChecked(false);
                vq233b.setChecked(false);
                vq234b.setChecked(false);
                score++;
            }
        });
        vq233b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq231b.setChecked(false);
                vq232b.setChecked(false);
                vq234b.setChecked(false);
            }
        });
        vq234b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq231b.setChecked(false);
                vq232b.setChecked(false);
                vq233b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score>=2&&intentnumber==3){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 2);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 2);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score>=2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), verbal5.class);
                    navio.putExtra("intentnumber",2);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<2){
                    Intent navio = new Intent(getBaseContext(), verbal1.class);
                    navio.putExtra("intentnumber",2);
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
                if(score>=2&&intentnumber==3){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 2);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 2);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score>=2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), verbal5.class);
                    navio.putExtra("intentnumber",2);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<2){
                    Intent navio = new Intent(getBaseContext(), verbal1.class);
                    navio.putExtra("intentnumber",2);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}