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

public class speed6 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;
    int presult;

    RadioButton sq611b;
    RadioButton sq612b;
    RadioButton sq621b;
    RadioButton sq622b;
    RadioButton sq631b;
    RadioButton sq632b;
    TextView sq61t;
    TextView sq62t;
    TextView sq63t;

    String mix_maroon = "mix=maroon (Dark Red)?";
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
        setContentView(R.layout.activity_speed6);
        timertext = findViewById(R.id.stimer6);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult", 0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult", 0);

        next = findViewById(R.id.snext6);
        sq61t = findViewById(R.id.sq61);
        sq62t = findViewById(R.id.sq62);
        sq63t = findViewById(R.id.sq63);

        sq611b = findViewById(R.id.sq611);
        sq612b = findViewById(R.id.sq612);
        sq621b = findViewById(R.id.sq621);
        sq622b = findViewById(R.id.sq622);
        sq631b = findViewById(R.id.sq631);
        sq632b = findViewById(R.id.sq632);
        sq611b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq612b.setChecked(false);
            }
        });
        sq612b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq611b.setChecked(false);
                score++;
            }
        });
        sq621b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq622b.setChecked(false);
            }
        });
        sq622b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq621b.setChecked(false);
                score++;
            }
        });
        sq631b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq632b.setChecked(false);
            }
        });
        sq632b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq631b.setChecked(false);
                score++;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score >= 2) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult", 6);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult", 6);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else {
                    Intent navio = new Intent(getBaseContext(), speed5.class);
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
                        sq61t.setBackgroundColor(Color.RED);
                        break;
                    case "0:56":
                        sq61t.setBackgroundColor(Color.WHITE);
                        break;
                    case "0:55":
                        sq61t.setBackgroundColor(0x800000);
                        sq61t.setText(mix_maroon);
                        break;
                    case "0:53": {
                        String number = three + five;
                        sq62t.setText(number);
                        break;
                    }
                    case "0:52": {
                        String number = multiply + three;
                        sq62t.setText(number);
                        break;
                    }
                    case "0:51": {
                        String number = divide + five;
                        sq62t.setText(number);
                        break;
                    }
                    case "0:50": {
                        String number = minus + one;
                        sq62t.setText(number);
                        break;
                    }
                    case "0:49": {
                        String number = equals + two + one;
                        sq62t.setText(number);
                        break;
                    }
                    case "0:47": {
                        String number = one + three;
                        sq63t.setText(number);
                        break;
                    }
                    case "0:46": {
                        String number = divide + three;
                        sq63t.setText(number);
                        break;
                    }
                    case "0:45": {
                        String number = multiply + nine;
                        sq63t.setText(number);
                        break;
                    }
                    case "0:44": {
                        String number = minus + six;
                        sq63t.setText(number);
                        break;
                    }
                    case "0:43": {
                        String number = equals + three + six;
                        sq63t.setText(number);
                        break;
                    }
                }
            }

            @Override
            public void onFinish() {
                if (score >= 2) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult", 6);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult", 6);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else {
                    Intent navio = new Intent(getBaseContext(), speed5.class);
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