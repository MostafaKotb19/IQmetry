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

public class memory3 extends AppCompatActivity {

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

    TextView mq31t;

    RadioButton mq311b;
    RadioButton mq312b;
    RadioButton mq313b;
    RadioButton mq314b;

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
        setContentView(R.layout.activity_memory3);
        timertext = findViewById(R.id.mtimer3);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult", 0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult", 0);
        sresult = Objects.requireNonNull(navio.getExtras()).getInt("sresult", 0);

        next = findViewById(R.id.mnext3);

        mq31t = findViewById(R.id.mq31);

        mq311b = findViewById(R.id.mq311);
        mq312b = findViewById(R.id.mq312);
        mq313b = findViewById(R.id.mq313);
        mq314b = findViewById(R.id.mq314);
        mq311b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq312b.setChecked(false);
                mq313b.setChecked(false);
                mq314b.setChecked(false);
                score++;
            }
        });
        mq312b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq311b.setChecked(false);
                mq313b.setChecked(false);
                mq314b.setChecked(false);
            }
        });
        mq313b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq311b.setChecked(false);
                mq312b.setChecked(false);
                mq314b.setChecked(false);
            }
        });
        mq314b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq311b.setChecked(false);
                mq312b.setChecked(false);
                mq313b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score == 1 && intentnumber == 4) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 3);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), memory2.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 3);
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
                        mq31t.setText(two);
                    case "0:27":
                        mq31t.setText(three);
                    case "0:26":
                        mq31t.setText(five);
                    case "0:25":
                        mq31t.setText(seven);
                    case "0:24":
                        mq31t.setText(answer);
                }
            }

            @Override
            public void onFinish() {
                if (score == 1 && intentnumber == 4) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 3);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), memory2.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 3);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}