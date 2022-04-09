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

public class verbal8 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;

    RadioButton vq811b;
    RadioButton vq812b;
    RadioButton vq813b;
    RadioButton vq814b;
    RadioButton vq821b;
    RadioButton vq822b;
    RadioButton vq823b;
    RadioButton vq824b;
    RadioButton vq831b;
    RadioButton vq832b;
    RadioButton vq833b;
    RadioButton vq834b;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_verbal8);
        timertext = findViewById(R.id.vtimer8);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");

        next = findViewById(R.id.vnext8);

        vq811b = findViewById(R.id.vq811);
        vq812b = findViewById(R.id.vq812);
        vq813b = findViewById(R.id.vq813);
        vq814b = findViewById(R.id.vq814);
        vq821b = findViewById(R.id.vq821);
        vq822b = findViewById(R.id.vq822);
        vq823b = findViewById(R.id.vq823);
        vq824b = findViewById(R.id.vq824);
        vq831b = findViewById(R.id.vq831);
        vq832b = findViewById(R.id.vq832);
        vq833b = findViewById(R.id.vq833);
        vq834b = findViewById(R.id.vq834);
        vq811b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq812b.setChecked(false);
                vq813b.setChecked(false);
                vq814b.setChecked(false);
            }
        });
        vq812b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq811b.setChecked(false);
                vq813b.setChecked(false);
                vq814b.setChecked(false);
                score++;
            }
        });
        vq813b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq811b.setChecked(false);
                vq812b.setChecked(false);
                vq814b.setChecked(false);
            }
        });
        vq814b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq811b.setChecked(false);
                vq812b.setChecked(false);
                vq813b.setChecked(false);
            }
        });
        vq821b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq822b.setChecked(false);
                vq823b.setChecked(false);
                vq824b.setChecked(false);
            }
        });
        vq822b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq821b.setChecked(false);
                vq823b.setChecked(false);
                vq824b.setChecked(false);
                score++;
            }
        });
        vq823b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq821b.setChecked(false);
                vq822b.setChecked(false);
                vq824b.setChecked(false);
            }
        });
        vq824b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq821b.setChecked(false);
                vq822b.setChecked(false);
                vq823b.setChecked(false);
            }
        });
        vq831b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq832b.setChecked(false);
                vq833b.setChecked(false);
                vq834b.setChecked(false);
            }
        });
        vq832b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq831b.setChecked(false);
                vq833b.setChecked(false);
                vq834b.setChecked(false);
                score++;
            }
        });
        vq833b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq831b.setChecked(false);
                vq832b.setChecked(false);
                vq834b.setChecked(false);
            }
        });
        vq834b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vq831b.setChecked(false);
                vq832b.setChecked(false);
                vq833b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score >= 2 && intentnumber == 5) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 8);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 8);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score < 2 && intentnumber == 5)) {
                    Intent navio = new Intent(getBaseContext(), verbal7.class);
                    navio.putExtra("intentnumber", 8);
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
                if (score >= 2 && intentnumber == 5) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), perceptual1.class);
                        navio.putExtra("vresult", 8);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), perceptual2.class);
                        navio.putExtra("vresult", 8);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score < 2 && intentnumber == 5)) {
                    Intent navio = new Intent(getBaseContext(), verbal7.class);
                    navio.putExtra("intentnumber", 8);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}