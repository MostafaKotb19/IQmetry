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

public class perceptual8 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;

    RadioButton pq811b;
    RadioButton pq812b;
    RadioButton pq813b;
    RadioButton pq814b;
    RadioButton pq821b;
    RadioButton pq822b;
    RadioButton pq823b;
    RadioButton pq824b;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_perceptual8);
        timertext = findViewById(R.id.ptimer8);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult",0);

        next = findViewById(R.id.pnext8);

        pq811b = findViewById(R.id.pq811);
        pq812b = findViewById(R.id.pq812);
        pq813b = findViewById(R.id.pq813);
        pq814b = findViewById(R.id.pq814);
        pq821b = findViewById(R.id.pq821);
        pq822b = findViewById(R.id.pq822);
        pq823b = findViewById(R.id.pq823);
        pq824b = findViewById(R.id.pq824);
        pq811b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq812b.setChecked(false);
                pq813b.setChecked(false);
                pq814b.setChecked(false);
            }
        });
        pq812b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq811b.setChecked(false);
                pq813b.setChecked(false);
                pq814b.setChecked(false);
                score++;
            }
        });
        pq813b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq811b.setChecked(false);
                pq812b.setChecked(false);
                pq814b.setChecked(false);
            }
        });
        pq814b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq811b.setChecked(false);
                pq812b.setChecked(false);
                pq813b.setChecked(false);
            }
        });
        pq821b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq822b.setChecked(false);
                pq823b.setChecked(false);
                pq824b.setChecked(false);
            }
        });
        pq822b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq821b.setChecked(false);
                pq823b.setChecked(false);
                pq824b.setChecked(false);
                score++;
            }
        });
        pq823b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq821b.setChecked(false);
                pq822b.setChecked(false);
                pq824b.setChecked(false);
            }
        });
        pq824b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pq821b.setChecked(false);
                pq822b.setChecked(false);
                pq823b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score == 2 && intentnumber == 5) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 8);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 8);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score <=1 && intentnumber == 5)) {
                    Intent navio = new Intent(getBaseContext(), perceptual7.class);
                    navio.putExtra("intentnumber", 8);
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
                if (score == 2 && intentnumber == 5) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), speed1.class);
                        navio.putExtra("presult", 8);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), speed2.class);
                        navio.putExtra("presult", 8);
                        navio.putExtra("vresult",vresult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score <=1 && intentnumber == 5)) {
                    Intent navio = new Intent(getBaseContext(), perceptual7.class);
                    navio.putExtra("intentnumber", 8);
                    navio.putExtra("vresult",vresult);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}