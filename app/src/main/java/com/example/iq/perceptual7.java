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

public class perceptual7 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;

    RadioButton pq711b;
    RadioButton pq712b;
    RadioButton pq713b;
    RadioButton pq714b;
    RadioButton pq721b;
    RadioButton pq722b;
    RadioButton pq723b;
    RadioButton pq724b;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_perceptual7);
        timertext = findViewById(R.id.ptimer7);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult",0);

        next = findViewById(R.id.pnext7);

        pq711b = findViewById(R.id.pq711);
        pq712b = findViewById(R.id.pq712);
        pq713b = findViewById(R.id.pq713);
        pq714b = findViewById(R.id.pq714);
        pq721b = findViewById(R.id.pq721);
        pq722b = findViewById(R.id.pq722);
        pq723b = findViewById(R.id.pq723);
        pq724b = findViewById(R.id.pq724);
        pq711b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq712b.setChecked(false);
                pq713b.setChecked(false);
                pq714b.setChecked(false);
            }
        });
        pq712b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq711b.setChecked(false);
                pq713b.setChecked(false);
                pq714b.setChecked(false);
            }
        });
        pq713b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq711b.setChecked(false);
                pq712b.setChecked(false);
                pq714b.setChecked(false);
            }
        });
        pq714b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq711b.setChecked(false);
                pq712b.setChecked(false);
                pq713b.setChecked(false);
                score++;
            }
        });
        pq721b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq722b.setChecked(false);
                pq723b.setChecked(false);
                pq724b.setChecked(false);
            }
        });
        pq722b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq721b.setChecked(false);
                pq723b.setChecked(false);
                pq724b.setChecked(false);
                score++;
            }
        });
        pq723b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq721b.setChecked(false);
                pq722b.setChecked(false);
                pq724b.setChecked(false);
            }
        });
        pq724b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq721b.setChecked(false);
                pq722b.setChecked(false);
                pq723b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score == 2 && intentnumber == 8) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 7);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 7);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score<=1 && intentnumber == 8)) {
                    Intent navio = new Intent(getBaseContext(), perceptual6.class);
                    navio.putExtra("intentnumber", 7);
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
                if (score == 2 && intentnumber == 8) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 7);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 7);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score<=1 && intentnumber == 8)) {
                    Intent navio = new Intent(getBaseContext(), perceptual6.class);
                    navio.putExtra("intentnumber", 7);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}