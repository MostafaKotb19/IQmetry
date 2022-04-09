package com.example.iq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Objects;

public class memory2 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 30000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;
    int presult;
    int sresult;
    String answer = "Answer";

    ImageView mq21t;

    RadioButton mq211b;
    RadioButton mq212b;
    RadioButton mq213b;
    RadioButton mq214b;

    String one = "1";
    String two = "2";
    String three = "3";
    String four = "4";
    String five = "5";
    String six = "6";
    String seven = "7";
    String eight = "8";
    String nine = "9";
    String zero = "0";
    String plus = "+";
    String minus = "-";
    String multiply = "x";
    String divide = "÷";
    String equals = "=";
    String dot = ".";


    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_memory2);
        timertext = findViewById(R.id.mtimer2);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult", 0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult", 0);
        sresult = Objects.requireNonNull(navio.getExtras()).getInt("sresult", 0);

        next = findViewById(R.id.mnext2);

        mq21t = findViewById(R.id.mq21);

        mq211b = findViewById(R.id.mq211);
        mq212b = findViewById(R.id.mq212);
        mq213b = findViewById(R.id.mq213);
        mq214b = findViewById(R.id.mq214);
        mq211b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq212b.setChecked(false);
                mq213b.setChecked(false);
                mq214b.setChecked(false);
                score++;
            }
        });
        mq212b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq211b.setChecked(false);
                mq213b.setChecked(false);
                mq214b.setChecked(false);
            }
        });
        mq213b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq211b.setChecked(false);
                mq212b.setChecked(false);
                mq214b.setChecked(false);
            }
        });
        mq214b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq211b.setChecked(false);
                mq212b.setChecked(false);
                mq213b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score == 1 && intentnumber == 3) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 2);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 1 && intentnumber == 0) {
                    Intent navio = new Intent(getBaseContext(), memory5.class);
                    navio.putExtra("intentnumber", 2);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), memory1.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 2);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        });
    }

    public void starttimer() {
        timer = new CountDownTimer(timeleft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleft = millisUntilFinished;
                int minutes = (int) timeleft / 60000;
                int seconds = (int) timeleft % 60000 / 1000;
                String timelefttext;
                timelefttext = "" + minutes;
                timelefttext += ":";
                if (seconds < 10) timelefttext += "0";
                timelefttext += seconds;
                timertext.setText(timelefttext);
                switch (timelefttext) {
                    case "0:28":
                        mq21t.setImageResource(R.drawable.mq21a);
                    case "0:27":
                        mq21t.setImageResource(R.drawable.mq21b);
                    case "0:26":
                        mq21t.setImageResource(R.drawable.mq21c);
                    case "0:25":
                        mq21t.setImageResource(R.drawable.answer);
                }
            }

            @Override
            public void onFinish() {
                if (score == 1 && intentnumber == 3) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 2);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 1 && intentnumber == 0) {
                    Intent navio = new Intent(getBaseContext(), memory5.class);
                    navio.putExtra("intentnumber", 2);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), memory1.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 2);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}