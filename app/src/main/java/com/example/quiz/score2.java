package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class score2 extends AppCompatActivity {
    int sc;
    TextView tv;
    String j;
    Button leaderboard;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score2);
            tv=findViewById(R.id.Score1);
        sp = getSharedPreferences("myprefer", 0);
            leaderboard=findViewById(R.id.ldr1);
        sc = sp.getInt("score", 0);

            j=String.valueOf(sc);
            tv.setText(""+j+"/10");

        }
    }

