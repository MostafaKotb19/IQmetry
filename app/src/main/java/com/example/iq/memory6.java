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

public class memory6 extends AppCompatActivity {


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

    ImageView mq61t;

    RadioButton mq611b;
    RadioButton mq612b;
    RadioButton mq613b;
    RadioButton mq614b;

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
        setContentView(R.layout.activity_memory6);
        timertext = findViewById(R.id.mtimer6);
        starttimer();

            Intent navio = getIntent();
            intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult", 0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult", 0);
        sresult = Objects.requireNonNull(navio.getExtras()).getInt("sresult", 0);

        next = findViewById(R.id.mnext6);

        mq61t = findViewById(R.id.mq61);

        mq611b = findViewById(R.id.mq611);
        mq612b = findViewById(R.id.mq612);
        mq613b = findViewById(R.id.mq613);
        mq614b = findViewById(R.id.mq614);
        mq611b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq612b.setChecked(false);
                mq613b.setChecked(false);
                mq614b.setChecked(false);
            }
        });
        mq612b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq611b.setChecked(false);
                mq613b.setChecked(false);
                mq614b.setChecked(false);
            }
        });
        mq613b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq611b.setChecked(false);
                mq612b.setChecked(false);
                mq614b.setChecked(false);
                score++;
            }
        });
        mq614b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mq611b.setChecked(false);
                mq612b.setChecked(false);
                mq613b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score == 1) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 6);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), memory5.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 6);
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
                        mq61t.setImageResource(R.drawable.mq61a);
                    case "0:27":
                        mq61t.setImageResource(R.drawable.mq61b);
                    case "0:26":
                        mq61t.setImageResource(R.drawable.mq61c);
                    case "0:25":
                        mq61t.setImageResource(R.drawable.mq61d);
                    case "0:24":
                        mq61t.setImageResource(R.drawable.mq61e);
                    case "0:23":
                        mq61t.setImageResource(R.drawable.answerinreverse);
                }
            }

            @Override
            public void onFinish() {
                if (score == 1) {
                    Intent navio = new Intent(getBaseContext(), result.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("mresult", 6);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score == 0) {
                    Intent navio = new Intent(getBaseContext(), memory5.class);
                    navio.putExtra("sresult", sresult);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("intentnumber", 6);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}