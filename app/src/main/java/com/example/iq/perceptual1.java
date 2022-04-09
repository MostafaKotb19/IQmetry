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

public class perceptual1 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;

    RadioButton pq111b;
    RadioButton pq112b;
    RadioButton pq113b;
    RadioButton pq114b;
    RadioButton pq121b;
    RadioButton pq122b;
    RadioButton pq123b;
    RadioButton pq124b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_perceptual1);
        timertext = findViewById(R.id.ptimer1);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult",0);

        next = findViewById(R.id.pnext1);

        pq111b = findViewById(R.id.pq111);
        pq112b = findViewById(R.id.pq112);
        pq113b = findViewById(R.id.pq113);
        pq114b = findViewById(R.id.pq114);
        pq121b = findViewById(R.id.pq121);
        pq122b = findViewById(R.id.pq122);
        pq123b = findViewById(R.id.pq123);
        pq124b = findViewById(R.id.pq124);
        pq111b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq112b.setChecked(false);
                pq113b.setChecked(false);
                pq114b.setChecked(false);
            }
        });
        pq112b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq111b.setChecked(false);
                pq113b.setChecked(false);
                pq114b.setChecked(false);
            }
        });
        pq113b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq111b.setChecked(false);
                pq112b.setChecked(false);
                pq114b.setChecked(false);
                score++;
            }
        });
        pq114b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq111b.setChecked(false);
                pq112b.setChecked(false);
                pq113b.setChecked(false);
            }
        });
        pq121b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq122b.setChecked(false);
                pq123b.setChecked(false);
                pq124b.setChecked(false);
            }
        });
        pq122b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq121b.setChecked(false);
                pq123b.setChecked(false);
                pq124b.setChecked(false);
            }
        });
        pq123b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq121b.setChecked(false);
                pq122b.setChecked(false);
                pq124b.setChecked(false);
            }
        });
        pq124b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq121b.setChecked(false);
                pq122b.setChecked(false);
                pq123b.setChecked(false);
                score++;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score==2&&intentnumber>1){
                    if(ageintent.equals("y")){
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult",1);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);}
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult",1);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                }
                else if(score==2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), perceptual5.class);
                    navio.putExtra("intentnumber",1);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<=1){
                    if(ageintent.equals("y")){
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult",0);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult",0);
                        navio.putExtra("vresult",vresult);
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
                if(score==2&&intentnumber>1){
                    if(ageintent.equals("y")){
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult",1);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);}
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult",1);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                }
                else if(score==2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), perceptual5.class);
                    navio.putExtra("intentnumber",1);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<=1){
                    if(ageintent.equals("y")){
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult",0);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult",0);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                }
            }
        }.start();
    }
}