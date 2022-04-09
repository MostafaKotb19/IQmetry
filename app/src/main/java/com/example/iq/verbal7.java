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

public class verbal7 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;

    RadioButton vq711b;
    RadioButton vq712b;
    RadioButton vq713b;
    RadioButton vq714b;
    RadioButton vq721b;
    RadioButton vq722b;
    RadioButton vq723b;
    RadioButton vq724b;
    RadioButton vq731b;
    RadioButton vq732b;
    RadioButton vq733b;
    RadioButton vq734b;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_verbal7);
        timertext = findViewById(R.id.vtimer7);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");

        next = findViewById(R.id.vnext7);

        vq711b = findViewById(R.id.vq711);
        vq712b = findViewById(R.id.vq712);
        vq713b = findViewById(R.id.vq713);
        vq714b = findViewById(R.id.vq714);
        vq721b = findViewById(R.id.vq721);
        vq722b = findViewById(R.id.vq722);
        vq723b = findViewById(R.id.vq723);
        vq724b = findViewById(R.id.vq724);
        vq731b = findViewById(R.id.vq731);
        vq732b = findViewById(R.id.vq732);
        vq733b = findViewById(R.id.vq733);
        vq734b = findViewById(R.id.vq734);
        vq711b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vq712b.isChecked()) {
                    vq713b.setChecked(false);
                    vq714b.setChecked(false);
                } else if (vq713b.isChecked()) {
                    vq712b.setChecked(false);
                    vq714b.setChecked(false);
                } else if (vq714b.isChecked()) {
                    vq712b.setChecked(false);
                    vq713b.setChecked(false);
                }
            }
        });
        vq712b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vq711b.isChecked()) {
                    vq713b.setChecked(false);
                    vq714b.setChecked(false);
                } else if (vq713b.isChecked()) {
                    vq711b.setChecked(false);
                    vq714b.setChecked(false);
                    score++;
                } else if (vq714b.isChecked()) {
                    vq711b.setChecked(false);
                    vq713b.setChecked(false);
                }
            }
        });
        vq713b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vq711b.isChecked()) {
                    vq712b.setChecked(false);
                    vq714b.setChecked(false);
                } else if (vq712b.isChecked()) {
                    vq711b.setChecked(false);
                    vq714b.setChecked(false);
                    score++;
                } else if (vq714b.isChecked()) {
                    vq711b.setChecked(false);
                    vq712b.setChecked(false);
                }
            }
        });
        vq714b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vq711b.isChecked()) {
                    vq712b.setChecked(false);
                    vq713b.setChecked(false);
                } else if (vq712b.isChecked()) {
                    vq711b.setChecked(false);
                    vq713b.setChecked(false);
                } else if (vq713b.isChecked()) {
                    vq711b.setChecked(false);
                    vq712b.setChecked(false);
                }
            }
        });
        vq721b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq722b.setChecked(false);
                vq723b.setChecked(false);
                vq724b.setChecked(false);
            }
        });
        vq722b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq721b.setChecked(false);
                vq723b.setChecked(false);
                vq724b.setChecked(false);
            }
        });
        vq723b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq721b.setChecked(false);
                vq722b.setChecked(false);
                vq724b.setChecked(false);
            }
        });
        vq724b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq721b.setChecked(false);
                vq722b.setChecked(false);
                vq723b.setChecked(false);
                score++;
            }
        });
        vq731b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq732b.setChecked(false);
                vq733b.setChecked(false);
                vq734b.setChecked(false);
            }
        });
        vq732b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq731b.setChecked(false);
                vq733b.setChecked(false);
                vq734b.setChecked(false);
            }
        });
        vq733b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq731b.setChecked(false);
                vq732b.setChecked(false);
                vq734b.setChecked(false);
            }
        });
        vq734b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq731b.setChecked(false);
                vq732b.setChecked(false);
                vq733b.setChecked(false);
                score++;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score >= 2 && intentnumber == 8) {
                    timer.cancel();
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 7);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 7);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score < 2 && intentnumber == 8)) {
                    Intent navio = new Intent(getBaseContext(), verbal6.class);
                    navio.putExtra("intentnumber", 7);
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
                if (score >= 2 && intentnumber == 8) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 7);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 7);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score < 2 && intentnumber == 8)) {
                    Intent navio = new Intent(getBaseContext(), verbal6.class);
                    navio.putExtra("intentnumber", 7);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}