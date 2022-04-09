package com.example.iq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import java.util.Objects;

public class result extends AppCompatActivity {
    int intentnumber = 0;
    String ageintent;
    double vresult;
    double presult;
    double sresult;
    double mresult;
    int total;
    String tvtipsl = "Read as widely as possible \n A new word a day \n Use what you learn \n " +
            "Keep a journal \n Become an active learner\n Look into common grammar mistakes";
    String tptipsl = "Learn spatial vocabulary \n Play with blocks \n Put together a puzzle \n Use and make maps \n " +
            "Play pattern-matching games \n Play video games, in moderation \n Use everyday moments as learning opportunities";
    String tstipsl = "Use technologies that increase reading speed \n Do crossword puzzles, Sudoku, or play online brain games \n" +
            "Play video games that practice the facets of information processing \n Teach typing skills \n Beat your best time";
    String tmtipsl = "Focus Your Attention \n Avoid Cramming \n Structure and Organize\n Utilize Mnemonic Devices \n " +
            "Visualize Concepts \n Relate New Information to Things You Already Know \n Read Out Loud \n Vary Your Study Routine";
    String tvtipsh = "Take an adult class \n Take a homophoneis test \n Learn a new language \n Study the roots of language \n " +
            "Volunteer as a teacher \n Play word games \n Read a quality newspaper";
    String tptipsh = "Use spatial language in everyday interactions \n Learn gestures and encourage yourself to use them to explain spatial relations \n" +
            "Teach yourself how to visualize using the mind’s eye \n Play tangram, non-jigsaw and other open-ended spatial puzzles \n " +
            "Read spatial-rich books \n Learn to play music \n Make three-dimensional crafts";
    String tstipsh = "Get plenty of aerobic exercise \n Eat the right foods \n Start playing an instrument \n Expand your repertoire of brain games";
    String tmtipsh = "Do brain training \n Meditate to improve your working memory \n Reduce sugar intake \n" +
            "Drink coffee to improve your memory consolidation";

    TextView ttotal;
    TextView tvresult;
    TextView tpresult;
    TextView tsresult;
    TextView tmresult;
    TextView vtips;
    TextView ptips;
    TextView stips;
    TextView mtips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_result);

        Intent navio = getIntent();
        intentnumber = Objects.requireNonNull(navio.getExtras()).getInt("intentnumber", 0);
        ageintent = Objects.requireNonNull(navio.getExtras()).getString("age", "");
        vresult = Objects.requireNonNull(navio.getExtras()).getInt("vresult", 0);
        presult = Objects.requireNonNull(navio.getExtras()).getInt("presult", 0);
        sresult = Objects.requireNonNull(navio.getExtras()).getInt("sresult", 0);
        mresult = Objects.requireNonNull(navio.getExtras()).getInt("mresult",0);
        total = (int) Math.sqrt(Math.exp(2)*(Math.pow(4*vresult,2)+Math.pow(4*presult,2)+Math.pow(2*sresult,2)+Math.pow(4*mresult,2)));
        ttotal= findViewById(R.id.total);
        tvresult = findViewById(R.id.verbal);
        tpresult = findViewById(R.id.perceptual);
        tsresult = findViewById(R.id.speed);
        tmresult = findViewById(R.id.memory);
        vtips = findViewById(R.id.vtips);
        ptips = findViewById(R.id.ptips);
        stips = findViewById(R.id.stips);
        mtips = findViewById(R.id.mtips);
        ttotal.setText(String.valueOf(total));
        vresult = (vresult/8.00)*100.00;
        presult = (presult/8.00)*100.00;
        sresult = (sresult/6.00)*100.00;
        mresult = (mresult/6.00)*100.00;
        tvresult.setText(String.valueOf(vresult));
        tpresult.setText(String.valueOf(presult));
        tsresult.setText(String.valueOf(sresult));
        tmresult.setText(String.valueOf(presult));
        if(vresult<50){
            vtips.setText(tvtipsl);
        }
        else if(vresult>50){
            vtips.setText(tvtipsh);
        }
        if(presult<50){
            ptips.setText(tptipsl);
        }
        else if(presult>50){
            ptips.setText(tptipsh);
        }
        if(sresult<50){
            stips.setText(tstipsl);
        }
        else if(sresult>50){
            stips.setText(tstipsh);
        }
        if(mresult<50){
            mtips.setText(tmtipsl);
        }
        else if(mresult>50){
            mtips.setText(tmtipsh);
        }
    }
}