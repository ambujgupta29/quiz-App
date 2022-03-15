package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class score1 extends AppCompatActivity {
    int sc;
    TextView tv;
    String j;
    Button leaderboard;
    private SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score1);
        sp = getSharedPreferences("mypref", 0);
        tv=findViewById(R.id.Score);
        leaderboard=findViewById(R.id.ldr);

        sc = sp.getInt("score ", 0);
        j=String.valueOf(sc);
        tv.setText(""+j+"/10");
        editor=sp.edit();
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                Intent intent=new Intent(score1.this,ldr1.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
