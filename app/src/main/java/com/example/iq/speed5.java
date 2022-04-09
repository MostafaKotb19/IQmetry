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

public class speed5 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;
    int presult;

    RadioButton sq511b;
    RadioButton sq512b;
    RadioButton sq521b;
    RadioButton sq522b;
    RadioButton sq531b;
    RadioButton sq532b;
    TextView sq51t;
    TextView sq52t;
    TextView sq53t;

    Handler handler;
    String mix_lime = "mix=lime?";
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
        setContentView(R.layout.activity_speed5);
        timertext = findViewById(R.id.stimer5);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult", 0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult", 0);

        next = findViewById(R.id.snext5);
        sq51t = findViewById(R.id.sq51);
        sq52t = findViewById(R.id.sq52);
        sq53t = findViewById(R.id.sq53);

        sq511b = findViewById(R.id.sq511);
        sq512b = findViewById(R.id.sq512);
        sq521b = findViewById(R.id.sq521);
        sq522b = findViewById(R.id.sq522);
        sq531b = findViewById(R.id.sq531);
        sq532b = findViewById(R.id.sq532);
        sq511b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq512b.setChecked(false);
                score++;
            }
        });
        sq512b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq511b.setChecked(false);
            }
        });
        sq521b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq522b.setChecked(false);
                score++;
            }
        });
        sq522b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq521b.setChecked(false);
            }
        });
        sq531b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq532b.setChecked(false);
            }
        });
        sq532b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq531b.setChecked(false);
                score++;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score >= 2 && intentnumber == 6) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult", 5);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult", 5);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score >= 2 && intentnumber == 1) || (score >= 2 && intentnumber == 2)) {
                    Intent navio = new Intent(getBaseContext(), speed6.class);
                    navio.putExtra("intentnumber", 5);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score < 2) {
                    Intent navio = new Intent(getBaseContext(), speed4.class);
                    navio.putExtra("intentnumber", 5);
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
                    case "0:57":
                        sq51t.setBackgroundColor(Color.YELLOW);
                        break;
                    case "0:56":
                        sq51t.setBackgroundColor(Color.WHITE);
                        break;
                    case "0:55":
                        sq51t.setBackgroundColor(Color.GREEN);
                        sq51t.setTextColor(Color.WHITE);
                        sq51t.setText(mix_lime);
                        break;
                    case "0:53": {
                        String number = two + zero;
                        sq52t.setText(number);
                        break;
                    }
                    case "0:52": {
                        String number = minus + three;
                        sq52t.setText(number);
                        break;
                    }
                    case "0:51": {
                        String number = multiply + four;
                        sq52t.setText(number);
                        break;
                    }
                    case "0:50": {
                        String number = multiply + two;
                        sq52t.setText(number);
                        break;
                    }
                    case "0:49": {
                        String number = equals + minus + four;
                        sq52t.setText(number);
                        break;
                    }
                    case "0:47": {
                        String number = five + zero;
                        sq53t.setText(number);
                        break;
                    }
                    case "0:46": {
                        String number = multiply + two;
                        sq53t.setText(number);
                        break;
                    }
                    case "0:45": {
                        String number = divide + three;
                        sq53t.setText(number);
                        break;
                    }
                    case "0:44": {
                        String number = multiply + six;
                        sq53t.setText(number);
                        break;
                    }
                    case "0:43": {
                        String number = equals + six + six + dot + six + seven;
                        sq53t.setText(number);
                        break;
                    }
                }
            }

            @Override
            public void onFinish() {
                if (score >= 2 && intentnumber == 6) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult", 5);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult", 5);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if ((score >= 2 && intentnumber == 1) || (score >= 2 && intentnumber == 2)) {
                    Intent navio = new Intent(getBaseContext(), speed6.class);
                    navio.putExtra("intentnumber", 5);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                } else if (score < 2) {
                    Intent navio = new Intent(getBaseContext(), speed4.class);
                    navio.putExtra("intentnumber", 5);
                    navio.putExtra("vresult", vresult);
                    navio.putExtra("presult", presult);
                    navio.putExtra("age", ageintent);
                    startActivity(navio);
                }
            }
        }.start();
    }
}