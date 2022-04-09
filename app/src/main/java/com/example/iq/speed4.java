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

public class speed4 extends AppCompatActivity {

    TextView timertext;
    CountDownTimer timer;
    long timeleft = 60000;

    int score = 0;

    int intentnumber = 0;
    String ageintent;
    int vresult;
    int presult;

    RadioButton sq411b;
    RadioButton sq412b;
    RadioButton sq421b;
    RadioButton sq422b;
    RadioButton sq431b;
    RadioButton sq432b;
    TextView sq41t;
    TextView sq42t;
    TextView sq43t;

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
        setContentView(R.layout.activity_speed4);
        timertext = findViewById(R.id.stimer4);
        starttimer();

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult", 0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult", 0);

        next = findViewById(R.id.snext4);
        sq41t = findViewById(R.id.sq41);
        sq42t = findViewById(R.id.sq42);
        sq43t = findViewById(R.id.sq43);

        sq411b = findViewById(R.id.sq411);
        sq412b = findViewById(R.id.sq412);
        sq421b = findViewById(R.id.sq421);
        sq422b = findViewById(R.id.sq422);
        sq431b = findViewById(R.id.sq431);
        sq432b = findViewById(R.id.sq432);
        sq411b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq412b.setChecked(false);
            }
        });
        sq412b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq411b.setChecked(false);
                score++;
            }
        });
        sq421b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq422b.setChecked(false);
                score++;
            }
        });
        sq422b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq421b.setChecked(false);
            }
        });
        sq431b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq432b.setChecked(false);
            }
        });
        sq432b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq431b.setChecked(false);
                score++;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (score >= 2 && intentnumber == 5) {
                    if (ageintent.equals("y")) {
                        Intent navio = new Intent(getBaseContext(), memory1.class);
                        navio.putExtra("sresult", 4);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    } else if (ageintent.equals("o")) {
                        Intent navio = new Intent(getBaseContext(), memory2.class);
                        navio.putExtra("sresult", 4);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                } else if (score < 2 && intentnumber == 5) {
                    Intent navio = new Intent(getBaseContext(), speed3.class);
                    navio.putExtra("intentnumber", 4);
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
                        sq41t.setBackgroundColor(Color.CYAN);
                        break;
                    case "0:57":
                        sq41t.setBackgroundColor(Color.YELLOW);
                        break;
                    case "0:56":
                        sq41t.setBackgroundColor(Color.MAGENTA);
                        break;
                    case "0:55":
                        sq41t.setBackgroundColor(Color.WHITE);
                        sq41t.setText(mix_white);
                        break;
                    case "0:53": {
                        sq42t.setText(three);
                        break;
                    }
                    case "0:52": {
                        String number = plus + nine;
                        sq42t.setText(number);
                        break;
                    }
                    case "0:51": {
                        String number = divide + three;
                        sq42t.setText(number);
                        break;
                    }
                    case "0:50": {
                        String number = plus + two;
                        sq42t.setText(number);
                        break;
                    }
                    case "0:49": {
                        String number = equals + eight;
                        sq42t.setText(number);
                        break;
                    }
                    case "0:47": {
                        String number = nine;
                        sq43t.setText(number);
                        break;
                    }
                    case "0:46": {
                        String number = minus + three;
                        sq43t.setText(number);
                        break;
                    }
                    case "0:45": {
                        String number = divide + three;
                        sq43t.setText(number);
                        break;
                    }
                    case "0:44": {
                        String number = equals + two;
                        sq43t.setText(number);
                        break;
                    }
                }
            }
                @Override
                public void onFinish () {
                    if (score >= 2 && intentnumber == 5) {
                        if (ageintent.equals("y")) {
                            Intent navio = new Intent(getBaseContext(), memory1.class);
                            navio.putExtra("sresult", 4);
                            navio.putExtra("vresult", vresult);
                            navio.putExtra("presult", presult);
                            navio.putExtra("age", ageintent);
                            startActivity(navio);
                        } else if (ageintent.equals("o")) {
                            Intent navio = new Intent(getBaseContext(), memory2.class);
                            navio.putExtra("sresult", 4);
                            navio.putExtra("vresult", vresult);
                            navio.putExtra("presult", presult);
                            navio.putExtra("age", ageintent);
                            startActivity(navio);
                        }
                    } else if (score < 2 && intentnumber == 5) {
                        Intent navio = new Intent(getBaseContext(), speed3.class);
                        navio.putExtra("intentnumber", 4);
                        navio.putExtra("vresult", vresult);
                        navio.putExtra("presult", presult);
                        navio.putExtra("age", ageintent);
                        startActivity(navio);
                    }
                }
        }.start();
    }
}