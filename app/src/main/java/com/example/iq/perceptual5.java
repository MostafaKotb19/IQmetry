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

public class perceptual5 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;

    RadioButton pq511b;
    RadioButton pq512b;
    RadioButton pq513b;
    RadioButton pq514b;
    RadioButton pq521b;
    RadioButton pq522b;
    RadioButton pq523b;
    RadioButton pq524b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_perceptual5);
        timertext = findViewById(R.id.ptimer5);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult",0);

        next = findViewById(R.id.pnext5);

        pq511b = findViewById(R.id.pq511);
        pq512b = findViewById(R.id.pq512);
        pq513b = findViewById(R.id.pq513);
        pq514b = findViewById(R.id.pq514);
        pq521b = findViewById(R.id.pq521);
        pq522b = findViewById(R.id.pq522);
        pq523b = findViewById(R.id.pq523);
        pq524b = findViewById(R.id.pq524);
        pq511b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq512b.setChecked(false);
                pq513b.setChecked(false);
                pq514b.setChecked(false);
                score++;
            }
        });
        pq512b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq511b.setChecked(false);
                pq513b.setChecked(false);
                pq514b.setChecked(false);
            }
        });
        pq513b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq511b.setChecked(false);
                pq512b.setChecked(false);
                pq514b.setChecked(false);
            }
        });
        pq514b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq511b.setChecked(false);
                pq512b.setChecked(false);
                pq513b.setChecked(false);
            }
        });
        pq521b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq522b.setChecked(false);
                pq523b.setChecked(false);
                pq524b.setChecked(false);
            }
        });
        pq522b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq521b.setChecked(false);
                pq523b.setChecked(false);
                pq524b.setChecked(false);
                score++;
            }
        });
        pq523b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq521b.setChecked(false);
                pq522b.setChecked(false);
                pq524b.setChecked(false);
            }
        });
        pq524b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq521b.setChecked(false);
                pq522b.setChecked(false);
                pq523b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score==2&&intentnumber==6){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 5);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 5);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if((score==2&&intentnumber==1)||(score==2&&intentnumber==2)){
                    Intent navio = new Intent(getBaseContext(), perceptual8.class);
                    navio.putExtra("intentnumber",5);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if((score<=1&&intentnumber==6)||(score<=1&&intentnumber==1)||(score<=1&&intentnumber==2)){
                    Intent navio = new Intent(getBaseContext(), perceptual4.class);
                    navio.putExtra("intentnumber",5);
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
                if(score==2&&intentnumber==6){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 5);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 5);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if((score==2&&intentnumber==1)||(score==2&&intentnumber==2)){
                    Intent navio = new Intent(getBaseContext(), perceptual8.class);
                    navio.putExtra("intentnumber",5);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if((score<=1&&intentnumber==6)||(score<=1&&intentnumber==1)||(score<=1&&intentnumber==2)){
                    Intent navio = new Intent(getBaseContext(), perceptual4.class);
                    navio.putExtra("intentnumber",5);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}