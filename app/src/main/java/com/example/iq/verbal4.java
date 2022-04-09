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

public class verbal4 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;

    RadioButton vq411b;
    RadioButton vq412b;
    RadioButton vq413b;
    RadioButton vq414b;
    RadioButton vq421b;
    RadioButton vq422b;
    RadioButton vq423b;
    RadioButton vq424b;
    RadioButton vq431b;
    RadioButton vq432b;
    RadioButton vq433b;
    RadioButton vq434b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_verbal4);
        timertext = findViewById(R.id.vtimer4);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");

        next = findViewById(R.id.vnext4);

        vq411b = findViewById(R.id.vq411);
        vq412b = findViewById(R.id.vq412);
        vq413b = findViewById(R.id.vq413);
        vq414b = findViewById(R.id.vq414);
        vq421b = findViewById(R.id.vq421);
        vq422b = findViewById(R.id.vq422);
        vq423b = findViewById(R.id.vq423);
        vq424b = findViewById(R.id.vq424);
        vq431b = findViewById(R.id.vq431);
        vq432b = findViewById(R.id.vq432);
        vq433b = findViewById(R.id.vq433);
        vq434b = findViewById(R.id.vq434);
        vq411b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq412b.setChecked(false);
                vq413b.setChecked(false);
                vq414b.setChecked(false);
            }
        });
        vq412b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq411b.setChecked(false);
                vq413b.setChecked(false);
                vq414b.setChecked(false);
            }
        });
        vq413b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq411b.setChecked(false);
                vq412b.setChecked(false);
                vq414b.setChecked(false);
                score++;
            }
        });
        vq414b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq411b.setChecked(false);
                vq412b.setChecked(false);
                vq413b.setChecked(false);
            }
        });
        vq421b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq422b.setChecked(false);
                vq423b.setChecked(false);
                vq424b.setChecked(false);
            }
        });
        vq422b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq421b.setChecked(false);
                vq423b.setChecked(false);
                vq424b.setChecked(false);
            }
        });
        vq423b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq421b.setChecked(false);
                vq422b.setChecked(false);
                vq424b.setChecked(false);
            }
        });
        vq424b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq421b.setChecked(false);
                vq422b.setChecked(false);
                vq423b.setChecked(false);
                score++;
            }
        });
        vq431b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq432b.setChecked(false);
                vq433b.setChecked(false);
                vq434b.setChecked(false);
            }
        });
        vq432b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq431b.setChecked(false);
                vq433b.setChecked(false);
                vq434b.setChecked(false);
                score++;
            }
        });
        vq433b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq431b.setChecked(false);
                vq432b.setChecked(false);
                vq434b.setChecked(false);
            }
        });
        vq434b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq431b.setChecked(false);
                vq432b.setChecked(false);
                vq433b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score>=2&&intentnumber==5){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 4);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 4);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score<2&&intentnumber==5){
                    Intent navio = new Intent(getBaseContext(), verbal3.class);
                    navio.putExtra("intentnumber",4);
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
                if(score>=2&&intentnumber==5){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 4);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 4);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score<2&&intentnumber==5){
                    Intent navio = new Intent(getBaseContext(), verbal3.class);
                    navio.putExtra("intentnumber",4);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}