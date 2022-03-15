package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class quiz4 extends AppCompatActivity {
    private Button next,lock;
    private TextView question;
    private RadioButton a, b, c, d, f;
    RadioGroup radioGroup;
    private ArrayList<technology> feed;
    int i = 0;
    int t=0;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        radioGroup=findViewById(R.id.radio2);
        question = findViewById(R.id.questionText2);
        a = findViewById(R.id.buttona1);
        b = findViewById(R.id.buttonb1);
        c = findViewById(R.id.buttonc1);
        d = findViewById(R.id.buttond1);
        sp = getSharedPreferences("mypreferences", 0);
        edit = sp.edit();
        ques2 obj = new ques2();
        feed=obj.abcde();
        question.setText(feed.get(i).getQuestion());
        a.setText(feed.get(i).getOpta());
        b.setText(feed.get(i).getOptb());
        c.setText(feed.get(i).getOptc());
        d.setText(feed.get(i).getOptd());
        next = findViewById(R.id.next2);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (i < (feed.size() - 1)) {
                    ++i;
                    question.setText(feed.get(i).getQuestion());
                    a.setText(feed.get(i).getOpta());
                    b.setText(feed.get(i).getOptb());
                    c.setText(feed.get(i).getOptc());
                    d.setText(feed.get(i).getOptd());
                    enablebuttons();
                    if (i == 9)
                        next.setText("Check Score");
                } else {
                    screenchange();
                }


            }        });
        lock=findViewById(R.id.lock2);
        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanswer();
                disablebuttons();
            }
        });
    }
    public void  checkanswer()
    {
        int l=radioGroup.getCheckedRadioButtonId();
        f=findViewById(l);
        if(f.getText().toString().equals(feed.get(i).getAnswer().toString()))
        {
            t++;
            edit.putInt("score", t);
            edit.apply();
            Toast.makeText(quiz4.this,"correct answer",Toast.LENGTH_SHORT).show();

        }
        else
            Toast.makeText(quiz4.this,"incorrect answer",Toast.LENGTH_SHORT).show();

    }
    public void disablebuttons()
    {
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
    }
    public void enablebuttons()
    {
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
    }
    public int score()
    {
        return sp.getInt("score", 0);
    }
    public void screenchange()
    {
        Intent intent=new Intent(this,score3.class);
        startActivity(intent);
        finish();
    }



}


