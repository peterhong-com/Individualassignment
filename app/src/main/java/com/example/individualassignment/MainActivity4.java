package com.example.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    TextView text;
    int minute;
    int second;
    int future;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button12,button11,button13,
            button14,button15,button16;
    Button bdNext;
    String time;
    View v;
    int target;
    int score;
    ArrayList<Integer> sco = new ArrayList<>();
    View.OnClickListener listener;
    protected ArrayList<Button> buttonList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        text=findViewById(R.id.level3timer);
        future=5000;
        Intent previous = getIntent();
        score=previous.getIntExtra("score",0);
        button1=findViewById(R.id.level31);button2=findViewById(R.id.level32);button3=findViewById(R.id.level33);
        button4=findViewById(R.id.level34);button5=findViewById(R.id.level35);button6=findViewById(R.id.level36);
        button7=findViewById(R.id.level37);button8=findViewById(R.id.level38);button9=findViewById(R.id.level39);
        button10=findViewById(R.id.level310);button11=findViewById(R.id.level311);button12=findViewById(R.id.level312);
        button13=findViewById(R.id.level313);button14=findViewById(R.id.level314);button15=findViewById(R.id.level315);
        button16=findViewById(R.id.level316);
        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(button5);
        buttonList.add(button6);
        buttonList.add(button7);
        buttonList.add(button8);
        buttonList.add(button9);       buttonList.add(button10);buttonList.add(button11);buttonList.add(button12);
        buttonList.add(button13);buttonList.add(button14);buttonList.add(button15);
        buttonList.add(button16);
        
        int i = (int) (Math.random() * buttonList.size());

        bdNext = buttonList.get(i);
        bdNext.setBackgroundColor(Color.YELLOW);
        target=bdNext.getId();


        target=buttonList.get(i).getId();

        bdNext = buttonList.get(i);
        bdNext.setBackgroundColor(Color.YELLOW);
        new CountDownTimer(future, 1000){
            public void onTick(long millisUntilFinished){
                future=future-1000;
                minute=future/6000;
                second=future%6000;
                time=String.valueOf(minute)+":"+String.valueOf(second);
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
                        Intent next = new Intent(getApplicationContext(),MainActivity5.class);
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
        listener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button bb = (Button)v;
                switch (bb.getId()){
                    case R.id.level31:{ if(target==R.id.level31) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level31) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level32: {  if(target==R.id.level32) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level32) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level33: {  if(target==R.id.level33) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level33) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level34: {  if(target==R.id.level34) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level34) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level35:{  if(target==R.id.level35) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level35) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level36: {  if(target==R.id.level36) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level36) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level37: {  if(target==R.id.level37) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level37) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level38: { if(target==R.id.level38) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level38) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level39: {  if(target==R.id.level39) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level39) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level310:{  if(target==R.id.level310) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level310) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level311: {  if(target==R.id.level311) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level311) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level312: {  if(target==R.id.level312) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level312) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level313: {  if(target==R.id.level313) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level313) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level314:{  if(target==R.id.level314) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level314) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level316: {  if(target==R.id.level316) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level316) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level315: {  if(target==R.id.level315) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level315) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                }

            }


        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        button10.setOnClickListener(listener);
        button12.setOnClickListener(listener);
        button13.setOnClickListener(listener);
        button14.setOnClickListener(listener);
        button15.setOnClickListener(listener);
        button11.setOnClickListener(listener);
        button16.setOnClickListener(listener);

    }
}