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

public class memory5 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 30000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;
    int presult;
    int sresult;
    String answer = "Answer in reverse";

    TextView mq51t;

    RadioButton mq511b;
    RadioButton mq512b;
    RadioButton mq513b;
    RadioButton mq514b;

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
        setContentView(R.layout.activity_memory5);
        timertext = findViewById(R.id.mtimer5);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult", 0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult", 0);
        sresult = Objects.requireNonNull(navio.getExtras()).getInt("sresult", 0);

        next = findViewById(R.id.mnext5);

        mq51t = findViewById(R.id.mq51);

        mq511b = findViewById(R.id.mq511);
        mq512b = findViewById(R.id.mq512);
        mq513b = findViewById(R.id.mq513);
        mq514b = findViewById(R.id.mq514);
        mq511b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq512b.setChecked(false);
                mq513b.setChecked(false);
                mq514b.setChecked(false);
            }
        });
        mq512b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq511b.setChecked(false);
                mq513b.setChecked(false);
                mq514b.setChecked(false);
            }
        });
        mq513b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq511b.setChecked(false);
                mq512b.setChecked(false);
                mq514b.setChecked(false);
            }
        });
        mq514b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq511b.setChecked(false);
                mq512b.setChecked(false);
                mq513b.setChecked(false);
                score++;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score == 1 && intentnumber == 6) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 5);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if ((score == 1 && intentnumber == 1) || (score == 1 && intentnumber == 2)) {
                    Intent navio = new Intent(getBaseContext(), memory6.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 5);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), memory4.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 5);
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
                        String number = two+zero;
                        mq51t.setText(number);
                    case "0:27":
                        number = three+eight;
                        mq51t.setText(number);
                    case "0:26":
                        number = nine+one;
                        mq51t.setText(number);
                    case "0:25":
                        number = seven+two;
                        mq51t.setText(number);
                    case "0:24":
                        number = four+one;
                        mq51t.setText(number);
                    case "0:23":
                        mq51t.setText(answer);
                }
            }

            @Override
            public void onFinish() {
                if (score == 1 && intentnumber == 6) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 5);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if ((score == 1 && intentnumber == 1) || (score == 1 && intentnumber == 2)) {
                    Intent navio = new Intent(getBaseContext(), memory6.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 5);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), memory4.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 5);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}