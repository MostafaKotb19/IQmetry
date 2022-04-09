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

public class perceptual3 extends AppCompatActivity {
    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;

    RadioButton pq311b;
    RadioButton pq312b;
    RadioButton pq313b;
    RadioButton pq314b;
    RadioButton pq321b;
    RadioButton pq322b;
    RadioButton pq323b;
    RadioButton pq324b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_perceptual3);
        timertext = findViewById(R.id.ptimer3);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult",0);

        next = findViewById(R.id.pnext3);

        pq311b = findViewById(R.id.pq311);
        pq312b = findViewById(R.id.pq312);
        pq313b = findViewById(R.id.pq313);
        pq314b = findViewById(R.id.pq314);
        pq321b = findViewById(R.id.pq321);
        pq322b = findViewById(R.id.pq322);
        pq323b = findViewById(R.id.pq323);
        pq324b = findViewById(R.id.pq324);
        pq311b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq312b.setChecked(false);
                pq313b.setChecked(false);
                pq314b.setChecked(false);
            }
        });
        pq312b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq311b.setChecked(false);
                pq313b.setChecked(false);
                pq314b.setChecked(false);
            }
        });
        pq313b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq311b.setChecked(false);
                pq312b.setChecked(false);
                pq314b.setChecked(false);
                score++;
            }
        });
        pq314b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq311b.setChecked(false);
                pq312b.setChecked(false);
                pq313b.setChecked(false);
            }
        });
        pq321b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq322b.setChecked(false);
                pq323b.setChecked(false);
                pq324b.setChecked(false);
            }
        });
        pq322b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq321b.setChecked(false);
                pq323b.setChecked(false);
                pq324b.setChecked(false);
                score++;
            }
        });
        pq323b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq321b.setChecked(false);
                pq322b.setChecked(false);
                pq324b.setChecked(false);
            }
        });
        pq324b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq321b.setChecked(false);
                pq322b.setChecked(false);
                pq323b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score==2&&intentnumber==4){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 3);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 3);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score<=1){
                    Intent navio = new Intent(getBaseContext(), perceptual2.class);
                    navio.putExtra("intentnumber",3);
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
                if(score==2&&intentnumber==4){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 3);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 3);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score<=1){
                    Intent navio = new Intent(getBaseContext(), perceptual2.class);
                    navio.putExtra("intentnumber",3);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}