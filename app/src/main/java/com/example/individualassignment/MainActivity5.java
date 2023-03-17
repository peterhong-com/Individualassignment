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

public class MainActivity5 extends AppCompatActivity {

    TextView text;
    int second;
    int future;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button12,button11,button13,
            button14,button15,button16,button17,button18,button19,button20,button21,button22,button23,button24,button25;
    Button bdNext;
    String time;
    View v;
    int target;
    int score;
    ArrayList<Integer> sco =new ArrayList<>();
    View.OnClickListener listener;
    protected ArrayList<Button> buttonList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        text=findViewById(R.id.level4timer);
        future=5000;
        text.setText(String.valueOf(future));
        Intent previous = getIntent();
        score=previous.getIntExtra("score",0);





        button1=findViewById(R.id.level41);button2=findViewById(R.id.level42);button3=findViewById(R.id.level43);
        button4=findViewById(R.id.level44);button5=findViewById(R.id.level45);button6=findViewById(R.id.level46);
        button7=findViewById(R.id.level47);button8=findViewById(R.id.level48);button9=findViewById(R.id.level49);
        button10=findViewById(R.id.level410);button11=findViewById(R.id.level411);button12=findViewById(R.id.level412);
        button13=findViewById(R.id.level413);button14=findViewById(R.id.level414);button15=findViewById(R.id.level415);
        button16=findViewById(R.id.level416);button17=findViewById(R.id.level417);
        button18=findViewById(R.id.level418);button19=findViewById(R.id.level419);
        button20=findViewById(R.id.level420);button21=findViewById(R.id.level421);button22=findViewById(R.id.level422);
        button23=findViewById(R.id.level423);button24=findViewById(R.id.level424);button25=findViewById(R.id.level425);
        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(button5);
        buttonList.add(button6);
        buttonList.add(button7);
        buttonList.add(button8);
        buttonList.add(button9);buttonList.add(button10);buttonList.add(button11);buttonList.add(button12);
        buttonList.add(button13);buttonList.add(button14);buttonList.add(button15);
        buttonList.add(button16); buttonList.add(button17);
        buttonList.add(button18);
        buttonList.add(button19);buttonList.add(button20);buttonList.add(button21);buttonList.add(button22);
        buttonList.add(button23);buttonList.add(button24);buttonList.add(button25);
        int i =(int) (Math.random() * buttonList.size());

        bdNext = buttonList.get(i);
        bdNext.setBackgroundColor(Color.YELLOW);
        target=bdNext.getId();;


        target=buttonList.get(i).getId();

        new CountDownTimer(future, 100){
            public void onTick(long millisUntilFinished){
                future=future-100;
                second=future/1000;
                time=String.valueOf(second);
                text.setText(String.valueOf(time));


            }
            public  void onFinish(){
                for(int i=0; i< buttonList.size(); i++){
                    buttonList.get(i).setClickable(false);
                }
                LinearLayout next=findViewById(R.id.linearNext4);
                Button next1=new Button(getApplicationContext());
                next1.setText("Next");
                next.addView(next1);
                next1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent next = new Intent(getApplicationContext(),MainActivity6.class);
                        next.putExtra("score",score);
                        startActivity(next);
                    }
                });
                LinearLayout end =findViewById(R.id.linearEnd4);
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
                        else {
                            Intent next = new Intent(getApplicationContext(), Rank.class);
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
                    case R.id.level41:{  if(target==R.id.level41) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level41) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level42: {  if(target==R.id.level42) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level42) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level43: {  if(target==R.id.level43) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level43) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level44: {   if(target==R.id.level44) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level44) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level45:{    if(target==R.id.level45) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level45) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level46: {  if(target==R.id.level46) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level46) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level47: {  if(target==R.id.level47) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level47) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level48: {  if(target==R.id.level48) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level48) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level49: {   if(target==R.id.level49) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level49) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level410:{   if(target==R.id.level410) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level410) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level411:{   if(target==R.id.level411) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level411) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level412: {  if(target==R.id.level412) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    while(buttonList.get(i).getId()==R.id.level412) {
                        i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW);
                    score++;}
                        break;}
                    case R.id.level413: {   if(target==R.id.level413) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    while(buttonList.get(i).getId()==R.id.level413) {
                        i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW);
                    score++;}
                        break;}
                    case R.id.level414:{   if(target==R.id.level414) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    while(buttonList.get(i).getId()==R.id.level414) {
                        i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW);
                    score++;}
                        break;}
                    case R.id.level416: {   if(target==R.id.level416) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                    int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    while(buttonList.get(i).getId()==R.id.level416) {
                        i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                    }
                    bdNext = buttonList.get(i);
                    bdNext.setBackgroundColor(Color.YELLOW);
                    score++;}
                        break;}
                    case R.id.level415:  {   if(target==R.id.level415) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level415) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level417:{   if(target==R.id.level417) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level417) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level418: {   if(target==R.id.level418) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level418) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level419: {   if(target==R.id.level419) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level419) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level420: {   if(target==R.id.level420) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level420) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level421:{   if(target==R.id.level421) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level421) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level422: {   if(target==R.id.level422) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level422) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level423:{   if(target==R.id.level423) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level423) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level424: {   if(target==R.id.level424) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level424) {
                            i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        }
                        bdNext = buttonList.get(i);
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level425: {   if(target==R.id.level425) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();
                        while(buttonList.get(i).getId()==R.id.level425) {
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
    }
}