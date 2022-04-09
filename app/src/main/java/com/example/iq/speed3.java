package com.example.iq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Objects;

public class speed3 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;
    int presult;

    RadioButton sq311b;
    RadioButton sq312b;
    RadioButton sq321b;
    RadioButton sq322b;
    RadioButton sq331b;
    RadioButton sq332b;
    TextView sq31t;
    TextView sq32t;
    TextView sq33t;
    Handler handler;
    String mix_white = "mix=white?";

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

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_speed3);
        timertext = findViewById(R.id.stimer3);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult", 0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult", 0);

        next = findViewById(R.id.snext3);

        sq31t = findViewById(R.id.sq31);
        sq32t = findViewById(R.id.sq32);
        sq33t = findViewById(R.id.sq33);

        sq311b = findViewById(R.id.sq311);
        sq312b = findViewById(R.id.sq312);
        sq321b = findViewById(R.id.sq321);
        sq322b = findViewById(R.id.sq322);
        sq331b = findViewById(R.id.sq331);
        sq332b = findViewById(R.id.sq332);
        sq311b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq312b.setChecked(false);
                score++;
            }
        });
        sq312b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq311b.setChecked(false);
            }
        });
        sq321b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq322b.setChecked(false);
            }
        });
        sq322b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq321b.setChecked(false);
                score++;
            }
        });
        sq331b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq332b.setChecked(false);
                score++;
            }
        });
        sq332b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq331b.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score >= 2 && intentnumber == 4) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult", 3);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult", 3);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if (score < 2) {
                    Intent navio = new Intent(getBaseContext(), speed2.class);
                    navio.putExtra("intentnumber", 3);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
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
                    case "0:58":
                        sq31t.setBackgroundColor(Color.RED);
                        break;
                    case "0:57":
                        sq31t.setBackgroundColor(Color.GREEN);
                        break;
                    case "0:56":
                        sq31t.setBackgroundColor(Color.BLUE);
                        break;
                    case "0:55":
                        sq31t.setBackgroundColor(Color.WHITE);
                        sq31t.setText(mix_white);
                        break;
                    case "0:53": {
                        sq32t.setText(one);
                        break;
                    }
                    case "0:52": {
                        String number = plus + five;
                        sq32t.setText(number);
                        break;
                    }
                    case "0:51": {
                        String number = minus + three;
                        sq32t.setText(number);
                        break;
                    }
                    case "0:50": {
                        String number = plus + two;
                        sq32t.setText(number);
                        break;
                    }
                    case "0:49": {
                        String number = equals + six;
                        sq32t.setText(number);
                        break;
                    }
                    case "0:47": {
                        String number = five;
                        sq33t.setText(number);
                        break;
                    }
                    case "0:46": {
                        String number = multiply + three;
                        sq33t.setText(number);
                        break;
                    }
                    case "0:45": {
                        String number = plus + five;
                        sq33t.setText(number);
                        break;
                    }
                    case "0:44": {
                        String number = equals + two + zero;
                        sq33t.setText(number);
                        break;
                    }
                }
            }

            @Override
            public void onFinish() {
                if (score >= 2 && intentnumber == 4) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult", 3);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult", 3);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if (score < 2) {
                    Intent navio = new Intent(getBaseContext(), speed2.class);
                    navio.putExtra("intentnumber", 3);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}