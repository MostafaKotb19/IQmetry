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

public class verbal6 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;

    RadioButton vq611b;
    RadioButton vq612b;
    RadioButton vq613b;
    RadioButton vq614b;
    RadioButton vq621b;
    RadioButton vq622b;
    RadioButton vq623b;
    RadioButton vq624b;
    RadioButton vq631b;
    RadioButton vq632b;
    RadioButton vq633b;
    RadioButton vq634b;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_verbal6);
        timertext = findViewById(R.id.vtimer6);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");

        next = findViewById(R.id.vnext6);

        vq611b = findViewById(R.id.vq611);
        vq612b = findViewById(R.id.vq612);
        vq613b = findViewById(R.id.vq613);
        vq614b = findViewById(R.id.vq614);
        vq621b = findViewById(R.id.vq621);
        vq622b = findViewById(R.id.vq622);
        vq623b = findViewById(R.id.vq623);
        vq624b = findViewById(R.id.vq624);
        vq631b = findViewById(R.id.vq631);
        vq632b = findViewById(R.id.vq632);
        vq633b = findViewById(R.id.vq633);
        vq634b = findViewById(R.id.vq634);
        vq611b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq612b.setChecked(false);
                vq613b.setChecked(false);
                vq614b.setChecked(false);
            }
        });
        vq612b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq611b.setChecked(false);
                vq613b.setChecked(false);
                vq614b.setChecked(false);
            }
        });
        vq613b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq611b.setChecked(false);
                vq612b.setChecked(false);
                vq614b.setChecked(false);
                score++;
            }
        });
        vq614b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq611b.setChecked(false);
                vq612b.setChecked(false);
                vq613b.setChecked(false);
            }
        });
        vq621b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq622b.setChecked(false);
                vq623b.setChecked(false);
                vq624b.setChecked(false);
            }
        });
        vq622b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq621b.setChecked(false);
                vq623b.setChecked(false);
                vq624b.setChecked(false);
            }
        });
        vq623b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq621b.setChecked(false);
                vq622b.setChecked(false);
                vq624b.setChecked(false);
                score++;
            }
        });
        vq624b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq621b.setChecked(false);
                vq622b.setChecked(false);
                vq623b.setChecked(false);
            }
        });
        vq631b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vq632b.isChecked()) {
                    vq633b.setChecked(false);
                    vq634b.setChecked(false);
                } else if (vq633b.isChecked()) {
                    vq632b.setChecked(false);
                    vq634b.setChecked(false);
                    score++;
                } else if (vq634b.isChecked()) {
                    vq632b.setChecked(false);
                    vq633b.setChecked(false);
                }
            }
        });
        vq632b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vq631b.isChecked()) {
                    vq633b.setChecked(false);
                    vq634b.setChecked(false);
                } else if (vq633b.isChecked()) {
                    vq631b.setChecked(false);
                    vq634b.setChecked(false);
                } else if (vq634b.isChecked()) {
                    vq631b.setChecked(false);
                    vq633b.setChecked(false);
                }
            }
        });
        vq633b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vq631b.isChecked()) {
                    vq632b.setChecked(false);
                    vq634b.setChecked(false);
                    score++;
                } else if (vq632b.isChecked()) {
                    vq631b.setChecked(false);
                    vq634b.setChecked(false);
                } else if (vq634b.isChecked()) {
                    vq631b.setChecked(false);
                    vq632b.setChecked(false);
                }
            }
        });
        vq634b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vq631b.isChecked()) {
                    vq632b.setChecked(false);
                    vq633b.setChecked(false);
                } else if (vq632b.isChecked()) {
                    vq631b.setChecked(false);
                    vq633b.setChecked(false);
                } else if (vq633b.isChecked()) {
                    vq631b.setChecked(false);
                    vq632b.setChecked(false);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score >= 2 && intentnumber == 7) {
                    timer.cancel();
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 6);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 6);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score < 2 && intentnumber == 7)) {
                    Intent navio = new Intent(getBaseContext(), verbal5.class);
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
            }

            @Override
            public void onFinish() {
                if (score >= 2 && intentnumber == 7) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 6);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 6);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score < 2 && intentnumber == 7)) {
                    Intent navio = new Intent(getBaseContext(), verbal5.class);
                    navio.putExtra("intentnumber", 6);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}