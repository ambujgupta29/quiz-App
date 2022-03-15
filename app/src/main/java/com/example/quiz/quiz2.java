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

public class quiz2 extends AppCompatActivity
{
    private Button next,lock;
    private TextView question;
    private RadioButton a, b, c, d, f;
    RadioGroup radioGroup;
    private ArrayList<technology> data;
    int i = 0;
    int t=0;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        radioGroup=findViewById(R.id.radio);
        question = findViewById(R.id.questionText);
        a = findViewById(R.id.buttonA);
        b = findViewById(R.id.buttonB);
        c = findViewById(R.id.buttonC);
        d = findViewById(R.id.buttonD);
        sp = getSharedPreferences("mypref", 0);
        edit = sp.edit();

        ques obj = new ques();
        data = obj.abc();
            question.setText(data.get(i).getQuestion());
            a.setText(data.get(i).getOpta());
            b.setText(data.get(i).getOptb());
            c.setText(data.get(i).getOptc());
            d.setText(data.get(i).getOptd());
            next = findViewById(R.id.next);
            next.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                         if (i<(data.size()-1)) {
                             ++i;
                             question.setText(data.get(i).getQuestion());
                             a.setText(data.get(i).getOpta());
                             b.setText(data.get(i).getOptb());
                             c.setText(data.get(i).getOptc());
                             d.setText(data.get(i).getOptd());

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
            lock=findViewById(R.id.lock);
            lock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkanswer();
                    disablebuttons();
                }
            });
    }
    public void checkanswer()
    {
        int l=radioGroup.getCheckedRadioButtonId();
        f=findViewById(l);
        if(f.getText().toString().equals(data.get(i).getAnswer()))
        {
            t++;
            edit.putInt("score", t);
            edit.apply();
            Toast.makeText(quiz2.this,"correct answer",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(quiz2.this,"incorrect answer",Toast.LENGTH_SHORT).show();
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
        Intent intent=new Intent(this,score1.class);
        startActivity(intent);
        finish();
    }

}