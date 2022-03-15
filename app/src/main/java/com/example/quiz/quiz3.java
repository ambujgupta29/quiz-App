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


public class quiz3 extends AppCompatActivity {
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
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        radioGroup=findViewById(R.id.radio1);
        question = findViewById(R.id.questionText1);
        a = findViewById(R.id.buttona);
        b = findViewById(R.id.buttonb);
        c = findViewById(R.id.buttonc);
        d = findViewById(R.id.buttond);
        sp = getSharedPreferences("myprefer", 0);
        edit = sp.edit();

        ques1 obj = new ques1();
        feed=obj.abcd();






        question.setText(feed.get(i).getQuestion());
        a.setText(feed.get(i).getOpta());
        b.setText(feed.get(i).getOptb());
        c.setText(feed.get(i).getOptc());
        d.setText(feed.get(i).getOptd());
        //do the same for abcd
        //increment i at the setText of d


        next = findViewById(R.id.next1);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //check if your ans is correct or not





                if (i<(feed.size()-1)) {
                    ++i;
                    question.setText(feed.get(i).getQuestion());
                    a.setText(feed.get(i).getOpta());
                    b.setText(feed.get(i).getOptb());
                    c.setText(feed.get(i).getOptc());
                    d.setText(feed.get(i).getOptd());

                    enablebuttons();
                    if(i==9)
                        next.setText("Check Score");
                }
                else
                {

                    screenchange();
                }






            }
        });
        lock=findViewById(R.id.lock1);
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
        if(f.getText().toString().equals(feed.get(i).getAnswer().toString())) {
            t++;
            edit.putInt("score", t);
            edit.apply();
            Toast.makeText(quiz3.this, "correct answer", Toast.LENGTH_SHORT).show();

        }
        else
            Toast.makeText(quiz3.this,"incorrect answer",Toast.LENGTH_SHORT).show();


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
        Intent intent=new Intent(this,score2.class);
        startActivity(intent);
        finish();
    }




}
