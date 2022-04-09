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

public class memory1 extends AppCompatActivity {

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

    TextView mq11t;

    RadioButton mq111b;
    RadioButton mq112b;
    RadioButton mq113b;
    RadioButton mq114b;

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
    String timelefttext = "0:30";


    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_memory1);
        timertext = findViewById(R.id.mtimer1);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult", 0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult", 0);
        sresult = Objects.requireNonNull(navio.getExtras()).getInt("sresult", 0);

        next = findViewById(R.id.mnext1);

        mq11t = findViewById(R.id.mq11);

        mq111b = findViewById(R.id.mq111);
        mq112b = findViewById(R.id.mq112);
        mq113b = findViewById(R.id.mq113);
        mq114b = findViewById(R.id.mq114);
        mq111b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq112b.setChecked(false);
                mq113b.setChecked(false);
                mq114b.setChecked(false);
            }
        });
        mq112b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq111b.setChecked(false);
                mq113b.setChecked(false);
                mq114b.setChecked(false);

            }
        });
        mq113b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq111b.setChecked(false);
                mq112b.setChecked(false);
                mq114b.setChecked(false);
                score++;
            }
        });
        mq114b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq111b.setChecked(false);
                mq112b.setChecked(false);
                mq113b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score == 1 && intentnumber > 1) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 1);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 1 && intentnumber == 0) {
                    Intent navio = new Intent(getBaseContext(), memory5.class);
                    navio.putExtra("intentnumber", 1);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 0);
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
                timelefttext = "" + minutes;
                timelefttext += ":";
                if (seconds < 10) timelefttext += "0";
                timelefttext += seconds;
                timertext.setText(timelefttext);
                switch (timelefttext) {
                    case "0:28":
                        mq11t.setText(five);
                        break;
                    case "0:27":
                        mq11t.setText(two);
                        break;
                    case "0:26":
                        mq11t.setText(nine);
                        break;
                    case "0:25":
                        mq11t.setText(answer);
                        break;
                }
            }

            @Override
            public void onFinish() {
                if (score == 1 && intentnumber > 1) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 1);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 1 && intentnumber == 0) {
                    Intent navio = new Intent(getBaseContext(), memory5.class);
                    navio.putExtra("intentnumber", 1);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 0);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}