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

public class MainActivity6 extends AppCompatActivity {
    TextView text;
    int minute;
    int second;
    int future;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button12,button11,button13,
            button14,button15,button16,button17,button18,button19,button20,button21,button22,button23,button24,button25,
            button26,button27,button28,button29,button30,button31,button32,button33,button34,button35,button36;
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
        setContentView(R.layout.activity_main6);
        text=findViewById(R.id.level5timer);
        future=5000;
        Intent previous = getIntent();
        score=previous.getIntExtra("score",0);


        button1=findViewById(R.id.level51);button2=findViewById(R.id.level52);button3=findViewById(R.id.level53);
        button4=findViewById(R.id.level54);button5=findViewById(R.id.level55);button6=findViewById(R.id.level56);
        button7=findViewById(R.id.level57);button8=findViewById(R.id.level58);button9=findViewById(R.id.level59);
        button10=findViewById(R.id.level510);button11=findViewById(R.id.level511);button12=findViewById(R.id.level512);
        button13=findViewById(R.id.level513);button14=findViewById(R.id.level514);button15=findViewById(R.id.level515);
        button16=findViewById(R.id.level516);button17=findViewById(R.id.level517);
        button18=findViewById(R.id.level518);button19=findViewById(R.id.level519);
        button20=findViewById(R.id.level520);button21=findViewById(R.id.level521);button22=findViewById(R.id.level522);
        button23=findViewById(R.id.level523);button24=findViewById(R.id.level524);button25=findViewById(R.id.level525);
        button26=findViewById(R.id.level526);button27=findViewById(R.id.level527);button28=findViewById(R.id.level528);
        button29=findViewById(R.id.level529);button30=findViewById(R.id.level530);button31=findViewById(R.id.level531);
        button32=findViewById(R.id.level532);button33=findViewById(R.id.level533);button34=findViewById(R.id.level534);
        button35=findViewById(R.id.level535);button36=findViewById(R.id.level536);
        buttonList.add(button1);buttonList.add(button2);buttonList.add(button3);
        buttonList.add(button4);buttonList.add(button5);buttonList.add(button6);
        buttonList.add(button7);buttonList.add(button8);buttonList.add(button9);
        buttonList.add(button10);buttonList.add(button11);buttonList.add(button12);
        buttonList.add(button13);buttonList.add(button14);buttonList.add(button15);
        buttonList.add(button16);  buttonList.add(button17);buttonList.add(button18);buttonList.add(button19);
        buttonList.add(button20);buttonList.add(button21);buttonList.add(button22);
        buttonList.add(button23);buttonList.add(button24);buttonList.add(button25);
        buttonList.add(button26);  buttonList.add(button27);buttonList.add(button28);buttonList.add(button29);
        buttonList.add(button30);buttonList.add(button31);buttonList.add(button32);
        buttonList.add(button33);  buttonList.add(button34);buttonList.add(button35);buttonList.add(button36);

        int i =(int) (Math.random() * buttonList.size());

        bdNext = buttonList.get(i);
        bdNext.setBackgroundColor(Color.YELLOW);
        target=bdNext.getId();;


        target=buttonList.get(i).getId();



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
        listener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button bb = (Button)v;
                switch (bb.getId()){
                    case R.id.level51:{  if(target==R.id.level51) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level51) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level52: {   if(target==R.id.level52) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level52) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level53: {  if(target==R.id.level53) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level53) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level54: {  if(target==R.id.level54) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level54) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level55:{    if(target==R.id.level55) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level55) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level56: {   if(target==R.id.level56) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level56) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level57: {   if(target==R.id.level57) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level57) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level58: {   if(target==R.id.level58) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level58) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level59: {   if(target==R.id.level59) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level59) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level510:{     if(target==R.id.level510) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level510) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level511:{   if(target==R.id.level511) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level511) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level512: {   if(target==R.id.level512) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    while(buttonList.get(i).getId()==R.id.level512) {
                        i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW);
                    score++;}
                        break;}
                    case R.id.level513: {   if(target==R.id.level513) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    while(buttonList.get(i).getId()==R.id.level513) {
                        i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW);
                    score++;}
                        break;}
                    case R.id.level514:{   if(target==R.id.level514) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    while(buttonList.get(i).getId()==R.id.level514) {
                        i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level516: {   if(target==R.id.level516) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level516) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level515:{   if(target==R.id.level515) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level515) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level517:{  if(target==R.id.level517) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    while(buttonList.get(i).getId()==R.id.level517) {
                        i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level518: {   if(target==R.id.level518) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    while(buttonList.get(i).getId()==R.id.level518) {
                        i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level519: {   if(target==R.id.level519) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level519) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level520: {   if(target==R.id.level520) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level520) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level521:{    if(target==R.id.level521) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level521) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level522: {   if(target==R.id.level522) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level522) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level523: {   if(target==R.id.level523) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level523) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level524: {   if(target==R.id.level524) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level524) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level525: {   if(target==R.id.level525) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level525) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level526: {   if(target==R.id.level526) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level526) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level527:{   if(target==R.id.level527) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level527) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level528: {   if(target==R.id.level528) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level528) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level529:{   if(target==R.id.level529) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level529) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level530:{  if(target==R.id.level530) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level530) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level531: {   if(target==R.id.level531) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level531) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level532: {   if(target==R.id.level532) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level532) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level533: {   if(target==R.id.level533) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level533) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level534: {   if(target==R.id.level534) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level534) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level535: {   if(target==R.id.level535) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level535) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level536: {   if(target==R.id.level536) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level536) {
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
        button17.setOnClickListener(listener);
        button18.setOnClickListener(listener);
        button19.setOnClickListener(listener);
        button20.setOnClickListener(listener);
        button21.setOnClickListener(listener);
        button22.setOnClickListener(listener);
        button23.setOnClickListener(listener);
        button24.setOnClickListener(listener);
        button25.setOnClickListener(listener);
        button26.setOnClickListener(listener);
        button27.setOnClickListener(listener);
        button28.setOnClickListener(listener);
        button29.setOnClickListener(listener);
        button30.setOnClickListener(listener);
        button31.setOnClickListener(listener);
        button32.setOnClickListener(listener);
        button33.setOnClickListener(listener);
        button34.setOnClickListener(listener);
        button35.setOnClickListener(listener);
        button36.setOnClickListener(listener);
       
    }

}