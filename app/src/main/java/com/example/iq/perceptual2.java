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

public class perceptual2 extends AppCompatActivity {
    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;

    RadioButton pq211b;
    RadioButton pq212b;
    RadioButton pq213b;
    RadioButton pq214b;
    RadioButton pq221b;
    RadioButton pq222b;
    RadioButton pq223b;
    RadioButton pq224b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_perceptual2);
        timertext = findViewById(R.id.ptimer2);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult",0);

        next = findViewById(R.id.pnext2);

        pq211b = findViewById(R.id.pq211);
        pq212b = findViewById(R.id.pq212);
        pq213b = findViewById(R.id.pq213);
        pq214b = findViewById(R.id.pq214);
        pq221b = findViewById(R.id.pq221);
        pq222b = findViewById(R.id.pq222);
        pq223b = findViewById(R.id.pq223);
        pq224b = findViewById(R.id.pq224);
        pq211b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq212b.setChecked(false);
                pq213b.setChecked(false);
                pq214b.setChecked(false);
            }
        });
        pq212b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq211b.setChecked(false);
                pq213b.setChecked(false);
                pq214b.setChecked(false);
            }
        });
        pq213b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq211b.setChecked(false);
                pq212b.setChecked(false);
                pq214b.setChecked(false);
                score++;
            }
        });
        pq214b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq211b.setChecked(false);
                pq212b.setChecked(false);
                pq213b.setChecked(false);
            }
        });
        pq221b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq222b.setChecked(false);
                pq223b.setChecked(false);
                pq224b.setChecked(false);
            }
        });
        pq222b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq221b.setChecked(false);
                pq223b.setChecked(false);
                pq224b.setChecked(false);
            }
        });
        pq223b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq221b.setChecked(false);
                pq222b.setChecked(false);
                pq224b.setChecked(false);
            }
        });
        pq224b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq221b.setChecked(false);
                pq222b.setChecked(false);
                pq223b.setChecked(false);
                score++;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score==2&&intentnumber==3){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 2);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 2);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score==2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), perceptual5.class);
                    navio.putExtra("intentnumber",2);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<=1){
                    Intent navio = new Intent(getBaseContext(), perceptual1.class);
                    navio.putExtra("intentnumber",2);
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
                if(score==2&&intentnumber==3){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 2);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 2);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score==2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), perceptual5.class);
                    navio.putExtra("intentnumber",2);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<=1){
                    Intent navio = new Intent(getBaseContext(), perceptual1.class);
                    navio.putExtra("intentnumber",2);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}