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

public class verbal1 extends AppCompatActivity {
    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;

    RadioButton vq111b;
    RadioButton vq112b;
    RadioButton vq113b;
    RadioButton vq114b;
    RadioButton vq121b;
    RadioButton vq122b;
    RadioButton vq123b;
    RadioButton vq124b;
    RadioButton vq131b;
    RadioButton vq132b;
    RadioButton vq133b;
    RadioButton vq134b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_verbal1);
        timertext = findViewById(R.id.vtimer1);
        starttimer();

        Intent age = getIntent();
        ageintent = Objects.requireNonNull(age.getExtras()).getString("age", "");
        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);

        next = findViewById(R.id.vnext1);

        vq111b = findViewById(R.id.vq111);
        vq112b = findViewById(R.id.vq112);
        vq113b = findViewById(R.id.vq113);
        vq114b = findViewById(R.id.vq114);
        vq121b = findViewById(R.id.vq121);
        vq122b = findViewById(R.id.vq122);
        vq123b = findViewById(R.id.vq123);
        vq124b = findViewById(R.id.vq124);
        vq131b = findViewById(R.id.vq131);
        vq132b = findViewById(R.id.vq132);
        vq133b = findViewById(R.id.vq133);
        vq134b = findViewById(R.id.vq134);
        vq111b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq112b.setChecked(false);
                vq113b.setChecked(false);
                vq114b.setChecked(false);
            }
        });
        vq112b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq111b.setChecked(false);
                vq113b.setChecked(false);
                vq114b.setChecked(false);
            }
        });
        vq113b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq111b.setChecked(false);
                vq112b.setChecked(false);
                vq114b.setChecked(false);
            }
        });
        vq114b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq111b.setChecked(false);
                vq112b.setChecked(false);
                vq113b.setChecked(false);
                score++;
            }
        });
        vq121b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq122b.setChecked(false);
                vq123b.setChecked(false);
                vq124b.setChecked(false);
            }
        });
        vq122b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq121b.setChecked(false);
                vq123b.setChecked(false);
                vq124b.setChecked(false);
                score++;
            }
        });
        vq123b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq121b.setChecked(false);
                vq122b.setChecked(false);
                vq124b.setChecked(false);
            }
        });
        vq124b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq121b.setChecked(false);
                vq122b.setChecked(false);
                vq123b.setChecked(false);
            }
        });
        vq131b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq132b.setChecked(false);
                vq133b.setChecked(false);
                vq134b.setChecked(false);
            }
        });
        vq132b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq131b.setChecked(false);
                vq133b.setChecked(false);
                vq134b.setChecked(false);
            }
        });
        vq133b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq131b.setChecked(false);
                vq132b.setChecked(false);
                vq134b.setChecked(false);
                score++;
            }
        });
        vq134b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq131b.setChecked(false);
                vq132b.setChecked(false);
                vq133b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score>=2&&intentnumber>1){
                    if(ageintent.equals("y")){
                    Intent navio = new Intent(getBaseContext(), perceptual1.class);
                    navio.putExtra("vresult",1);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);}
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult",1);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                }
                else if(score>=2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), verbal5.class);
                    navio.putExtra("intentnumber",1);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<2){
                    if(ageintent.equals("y")){
                    Intent navio = new Intent(getBaseContext(), perceptual1.class);
                    navio.putExtra("vresult",0);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult",0);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
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
                if(score>=2&&intentnumber>1){
                    if(ageintent.equals("y")){
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult",1);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);}
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult",1);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                }
                else if(score>=2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), verbal5.class);
                    navio.putExtra("intentnumber",1);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<2){
                    if(ageintent.equals("y")){
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult",0);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult",0);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                }
            }
        }.start();
    }
}