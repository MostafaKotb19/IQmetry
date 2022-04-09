package com.example.iq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Objects;

public class memory4 extends AppCompatActivity {

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

    TextView mq41t;

    RadioButton mq411b;
    RadioButton mq412b;
    RadioButton mq413b;
    RadioButton mq414b;

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
        setContentView(R.layout.activity_memory4);
        timertext = findViewById(R.id.mtimer4);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult", 0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult", 0);
        sresult = Objects.requireNonNull(navio.getExtras()).getInt("sresult", 0);

        next = findViewById(R.id.mnext4);

        mq41t = findViewById(R.id.mq41);

        mq411b = findViewById(R.id.mq411);
        mq412b = findViewById(R.id.mq412);
        mq413b = findViewById(R.id.mq413);
        mq414b = findViewById(R.id.mq414);
        mq411b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq412b.setChecked(false);
                mq413b.setChecked(false);
                mq414b.setChecked(false);
            }
        });
        mq412b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq411b.setChecked(false);
                mq413b.setChecked(false);
                mq414b.setChecked(false);
            }
        });
        mq413b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq411b.setChecked(false);
                mq412b.setChecked(false);
                mq414b.setChecked(false);
                score++;
            }
        });
        mq414b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq411b.setChecked(false);
                mq412b.setChecked(false);
                mq413b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score == 1 && intentnumber == 5) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 4);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), memory3.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 4);
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
                        mq41t.setBackgroundColor(Color.RED);
                    case "0:27":
                        mq41t.setBackgroundColor(0xa4c639);
                    case "0:26":
                        mq41t.setBackgroundColor(Color.YELLOW);
                    case "0:25":
                        mq41t.setBackgroundColor(Color.GREEN);
                    case "0:24":
                        mq41t.setBackgroundColor(Color.TRANSPARENT);
                        mq41t.setText(answer);
                }
            }

            @Override
            public void onFinish() {
                if (score == 1 && intentnumber == 5) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 4);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), memory3.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 4);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}