package com.example.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener  {

    TextView text;
    int second;
    int future;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button bdNext;
    String time;
    int target;
    int score;
    ArrayList<Integer> sco = new ArrayList<>();
    protected ArrayList<Button> buttonList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        score=0;
        text=findViewById(R.id.level1timer);
        future=5100;
        button1=findViewById(R.id.level11);
        button2=findViewById(R.id.level12);
        button3=findViewById(R.id.level13);
        button4=findViewById(R.id.level14);
        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        int i = (int) (Math.random() * buttonList.size());

        bdNext = buttonList.get(i);
        target= bdNext.getId();
        bdNext.setBackgroundColor(Color.YELLOW);

        new CountDownTimer(future, 100){
            public void onTick(long millisUntilFinished){
                future=future-100;
                second=future/6000;
                time=String.valueOf(second);
                text.setText(String.valueOf(time));


            }
            public  void onFinish(){
                for(int i=0; i< buttonList.size(); i++){
                    buttonList.get(i).setClickable(false);
                }
                LinearLayout next=findViewById(R.id.linearNext1);
                Button next1=new Button(getApplicationContext());
                next1.setText("Next");
                next.addView(next1);
                next1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent next = new Intent(getApplicationContext(),MainActivity3.class);
                        next.putExtra("score",score);
                        startActivity(next);
                    }
                });
                LinearLayout end =findViewById(R.id.linearEnd1);
                Button end1 = new Button(getApplicationContext());
                end1.setText("Finish");
                end.addView(end1);
                end1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Score mySQLiteAdapter = new Score(getApplicationContext());
                        mySQLiteAdapter.openToRead();
                        sco = mySQLiteAdapter.queue();
                        if(sco.size()==0){
                            Intent next = new Intent(getApplicationContext(), EnterName.class);
                            next.putExtra("score", score);
                            startActivity(next);
                        }
                        else if(sco.size()<25) {
                            Intent next = new Intent(getApplicationContext(), EnterName.class);
                            next.putExtra("score", score);
                            startActivity(next);
                        }
                        else if(score>sco.get(sco.size()-1)) {
                            Intent next = new Intent(getApplicationContext(), EnterName.class);
                            next.putExtra("score", score);
                            startActivity(next);
                        }
                    }
                });
            }
        }.start();

        button1.setOnClickListener(this::onClick);
        button2.setOnClickListener(this::onClick);
        button3.setOnClickListener(this::onClick);
        button4.setOnClickListener(this::onClick);

        }
        @Override
    public void onClick(View v) {

            switch (v.getId()){
                case R.id.level11:{  System.out.println(422);
                    if(target==R.id.level11) {
                        v.setBackgroundColor(Color.parseColor("#03A9F4"));
                        System.out.println(422);
                        int i = (int) (Math.random() * buttonList.size());
                        target=buttonList.get(i).getId();
                        while (buttonList.get(i).getId() == R.id.level11) {
                            i = (int) (Math.random() * buttonList.size());
                            target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;
                        System.out.println(score);
                    }
                    System.out.println(422);
                    break;}
                case R.id.level12: { if(target==R.id.level12) { v.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int) (Math.random() * buttonList.size());
                    target=buttonList.get(i).getId();
                    while (buttonList.get(i).getId() == R.id.level12) {
                        i = (int) (Math.random() * buttonList.size());
                        target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW); score++;
                }
                    break;}
                case R.id.level13: {  if(target==R.id.level13) {v.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int) (Math.random() * buttonList.size());
                    target=buttonList.get(i).getId();
                    while (buttonList.get(i).getId() == R.id.level13) {
                        i = (int) (Math.random() * buttonList.size());
                        target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW); score++;
                }
                    break;}
                case R.id.level14: { if(target==R.id.level14) { v.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int) (Math.random() * buttonList.size());
                    target=buttonList.get(i).getId();
                    while (buttonList.get(i).getId() == R.id.level14) {
                        i = (int) (Math.random() * buttonList.size());target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW); score++;
                }
                    break;}
            }
        }

}