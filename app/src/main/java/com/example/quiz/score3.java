package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class score3 extends AppCompatActivity {
    int sc;
    TextView tv;
    String j;
    Button leaderboard;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score3);
        tv=findViewById(R.id.Score2);
        sp = getSharedPreferences("mypreferences", 0);
        leaderboard=findViewById(R.id.ldr2);
        sc = sp.getInt("score", 0);
        j=String.valueOf(sc);
        tv.setText(""+j+"/10");
    }
}
