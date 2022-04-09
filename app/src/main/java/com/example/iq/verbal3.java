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

public class verbal3 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;

    RadioButton vq311b;
    RadioButton vq312b;
    RadioButton vq313b;
    RadioButton vq314b;
    RadioButton vq321b;
    RadioButton vq322b;
    RadioButton vq323b;
    RadioButton vq324b;
    RadioButton vq331b;
    RadioButton vq332b;
    RadioButton vq333b;
    RadioButton vq334b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_verbal3);
        timertext = findViewById(R.id.vtimer3);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");

        next = findViewById(R.id.vnext3);

        vq311b = findViewById(R.id.vq311);
        vq312b = findViewById(R.id.vq312);
        vq313b = findViewById(R.id.vq313);
        vq314b = findViewById(R.id.vq314);
        vq321b = findViewById(R.id.vq321);
        vq322b = findViewById(R.id.vq322);
        vq323b = findViewById(R.id.vq323);
        vq324b = findViewById(R.id.vq324);
        vq331b = findViewById(R.id.vq331);
        vq332b = findViewById(R.id.vq332);
        vq333b = findViewById(R.id.vq333);
        vq334b = findViewById(R.id.vq334);
        vq311b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq312b.setChecked(false);
                vq313b.setChecked(false);
                vq314b.setChecked(false);
            }
        });
        vq312b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq311b.setChecked(false);
                vq313b.setChecked(false);
                vq314b.setChecked(false);
            }
        });
        vq313b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq311b.setChecked(false);
                vq312b.setChecked(false);
                vq314b.setChecked(false);
            }
        });
        vq314b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq311b.setChecked(false);
                vq312b.setChecked(false);
                vq313b.setChecked(false);
                score++;
            }
        });
        vq321b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq322b.setChecked(false);
                vq323b.setChecked(false);
                vq324b.setChecked(false);
            }
        });
        vq322b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq321b.setChecked(false);
                vq323b.setChecked(false);
                vq324b.setChecked(false);
            }
        });
        vq323b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq321b.setChecked(false);
                vq322b.setChecked(false);
                vq324b.setChecked(false);
            }
        });
        vq324b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq321b.setChecked(false);
                vq322b.setChecked(false);
                vq323b.setChecked(false);
                score++;
            }
        });
        vq331b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq332b.setChecked(false);
                vq333b.setChecked(false);
                vq334b.setChecked(false);
            }
        });
        vq332b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq331b.setChecked(false);
                vq333b.setChecked(false);
                vq334b.setChecked(false);
            }
        });
        vq333b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq331b.setChecked(false);
                vq332b.setChecked(false);
                vq334b.setChecked(false);
            }
        });
        vq334b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq331b.setChecked(false);
                vq332b.setChecked(false);
                vq333b.setChecked(false);
                score++;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score>=2&&intentnumber==4){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 3);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 3);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score<2){
                    Intent navio = new Intent(getBaseContext(), verbal2.class);
                    navio.putExtra("intentnumber",3);
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
                if(score>=2&&intentnumber==4){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 3);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 3);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score<2){
                    Intent navio = new Intent(getBaseContext(), verbal2.class);
                    navio.putExtra("intentnumber",3);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}