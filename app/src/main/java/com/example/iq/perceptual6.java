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

public class perceptual6 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;

    RadioButton pq611b;
    RadioButton pq612b;
    RadioButton pq613b;
    RadioButton pq614b;
    RadioButton pq621b;
    RadioButton pq622b;
    RadioButton pq623b;
    RadioButton pq624b;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_perceptual6);
        timertext = findViewById(R.id.ptimer6);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult",0);

        next = findViewById(R.id.pnext6);

        pq611b = findViewById(R.id.pq611);
        pq612b = findViewById(R.id.pq612);
        pq613b = findViewById(R.id.pq613);
        pq614b = findViewById(R.id.pq614);
        pq621b = findViewById(R.id.pq621);
        pq622b = findViewById(R.id.pq622);
        pq623b = findViewById(R.id.pq623);
        pq624b = findViewById(R.id.pq624);
        pq611b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq612b.setChecked(false);
                pq613b.setChecked(false);
                pq614b.setChecked(false);
            }
        });
        pq612b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq611b.setChecked(false);
                pq613b.setChecked(false);
                pq614b.setChecked(false);
            }
        });
        pq613b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq611b.setChecked(false);
                pq612b.setChecked(false);
                pq614b.setChecked(false);
            }
        });
        pq614b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq611b.setChecked(false);
                pq612b.setChecked(false);
                pq613b.setChecked(false);
                score++;
            }
        });
        pq621b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq622b.setChecked(false);
                pq623b.setChecked(false);
                pq624b.setChecked(false);
                score++;
            }
        });
        pq622b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq621b.setChecked(false);
                pq623b.setChecked(false);
                pq624b.setChecked(false);
            }
        });
        pq623b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq621b.setChecked(false);
                pq622b.setChecked(false);
                pq624b.setChecked(false);
            }
        });
        pq624b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq621b.setChecked(false);
                pq622b.setChecked(false);
                pq623b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score == 2 && intentnumber == 7) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 6);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 6);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score<=1 && intentnumber == 7)) {
                    Intent navio = new Intent(getBaseContext(), perceptual5.class);
                    navio.putExtra("intentnumber", 6);
                    navio.putExtra("vresult",vresult);
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
                if (score == 2 && intentnumber == 7) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 6);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 6);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score<=1 && intentnumber == 7)) {
                    Intent navio = new Intent(getBaseContext(), perceptual5.class);
                    navio.putExtra("intentnumber", 6);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}