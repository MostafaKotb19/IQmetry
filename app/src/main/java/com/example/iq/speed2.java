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

public class speed2 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 15000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;
    int presult;

    RadioButton sq211b;
    RadioButton sq212b;
    RadioButton sq221b;
    RadioButton sq222b;
    RadioButton sq231b;
    RadioButton sq232b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_speed2);
        timertext = findViewById(R.id.stimer2);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult",0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult",0);

        next = findViewById(R.id.snext2);

        sq211b = findViewById(R.id.sq211);
        sq212b = findViewById(R.id.sq212);
        sq221b = findViewById(R.id.sq221);
        sq222b = findViewById(R.id.sq222);
        sq231b = findViewById(R.id.sq231);
        sq232b = findViewById(R.id.sq232);
        sq211b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq212b.setChecked(false);
                score++;
                    }
        });
        sq212b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq211b.setChecked(false);
            }
        });
        sq221b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq222b.setChecked(false);
            }
        });
        sq222b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq221b.setChecked(false);
                score++;
                    }
        });
        sq231b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq232b.setChecked(false);
                score++;
            }
        });
        sq232b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq231b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score>=2&&intentnumber==3){
                    if(ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult", 2);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult", 2);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score>=2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), speed5.class);
                    navio.putExtra("intentnumber",2);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("presult",presult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<2){
                    Intent navio = new Intent(getBaseContext(), speed1.class);
                    navio.putExtra("intentnumber",2);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("presult",presult);
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
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult", 2);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult", 2);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
                else if(score>=2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), speed5.class);
                    navio.putExtra("intentnumber",2);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("presult",presult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<2){
                    Intent navio = new Intent(getBaseContext(), speed1.class);
                    navio.putExtra("intentnumber",2);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("presult",presult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}