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

public class speed1 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 15000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;
    int presult;

    RadioButton sq111b;
    RadioButton sq112b;
    RadioButton sq121b;
    RadioButton sq122b;
    RadioButton sq131b;
    RadioButton sq132b;

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_speed1);
        timertext = findViewById(R.id.stimer1);
        starttimer();


        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber",0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult",0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult",0);

        next = findViewById(R.id.snext1);

        sq111b = findViewById(R.id.sq111);
        sq112b = findViewById(R.id.sq112);
        sq121b = findViewById(R.id.sq121);
        sq122b = findViewById(R.id.sq122);
        sq131b = findViewById(R.id.sq131);
        sq132b = findViewById(R.id.sq132);
        sq111b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq112b.setChecked(false);
                }
        });
        sq112b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq111b.setChecked(false);
                score++;
            }
        });
        sq121b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq122b.setChecked(false);
                    }
        });
        sq122b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq121b.setChecked(false);
                score++;
            }
        });
        sq131b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq132b.setChecked(false);
                score++;
                    }
        });
        sq132b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq131b.setChecked(false);
                    }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(score>=2&&intentnumber>1){
                    if(ageintent.equals("y")){
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult",1);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);}
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult",1);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                }
                else if(score>=2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), speed5.class);
                    navio.putExtra("intentnumber",1);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("presult",presult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<2){
                    if(ageintent.equals("y")){
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult",0);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult",0);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
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
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult",1);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);}
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult",1);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                }
                else if(score>=2&&intentnumber==0){
                    Intent navio = new Intent(getBaseContext(), speed5.class);
                    navio.putExtra("intentnumber",1);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("presult",presult);
                    navio.putExtra("age",ageintent);
                    startActivity(navio);
                }
                else if(score<2){
                    if(ageintent.equals("y")){
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult",0);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                    else if(ageintent.equals("o")){
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult",0);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("presult",presult);
                        navio.putExtra("age",ageintent);
                        startActivity(navio);
                    }
                }
            }
        }.start();
    }
}