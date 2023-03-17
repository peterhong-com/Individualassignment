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

public class MainActivity3 extends AppCompatActivity {

    TextView text;
    int second;
    int future;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button bdNext;
    String time;
    View v;
    int score;
    int target;
    View.OnClickListener listener;
    ArrayList<Integer> sco=new ArrayList<>();
    protected ArrayList<Button> buttonList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        text=findViewById(R.id.level2timer);
        future=5100;
        Intent previous = getIntent();
        score=previous.getIntExtra("score",0);
        button1=findViewById(R.id.level21);
        button2=findViewById(R.id.level22);
        button3=findViewById(R.id.level23);
        button4=findViewById(R.id.level24);
        button5=findViewById(R.id.level25);
        button6=findViewById(R.id.level26);
        button7=findViewById(R.id.level27);
        button8=findViewById(R.id.level28);
        button9=findViewById(R.id.level29);
        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(button5);
        buttonList.add(button6);
        buttonList.add(button7);
        buttonList.add(button8);
        buttonList.add(button9);
        int i = i = (int) (Math.random() * buttonList.size());

        bdNext = buttonList.get(i);
        bdNext.setBackgroundColor(Color.YELLOW);
        target=bdNext.getId();
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
                        Intent next = new Intent(getApplicationContext(),MainActivity4.class);
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
                    case R.id.level21:{ if(target==R.id.level21) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();;
                        while(buttonList.get(i).getId()==R.id.level21) {
                            i = i = (int) (Math.random() * buttonList.size());target=buttonList.get(i).getId();;
                        }
                        bdNext = findViewById(buttonList.get(i).getId());
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level22: { if(target==R.id.level22) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();;
                        while(buttonList.get(i).getId()==R.id.level22) {
                            i = i = (int) (Math.random() * buttonList.size());target=buttonList.get(i).getId();;
                        }
                        bdNext = findViewById(buttonList.get(i).getId());
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level23: { if(target==R.id.level23) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();;
                        while(buttonList.get(i).getId()==R.id.level23) {
                            i = i = (int) (Math.random() * buttonList.size());target=buttonList.get(i).getId();;
                        }
                        bdNext = findViewById(buttonList.get(i).getId());
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level24: {if(target==R.id.level24) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();;
                        while(buttonList.get(i).getId()==R.id.level24) {
                            i = i = (int) (Math.random() * buttonList.size());target=buttonList.get(i).getId();;
                        }
                        bdNext = findViewById(buttonList.get(i).getId());
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level25:{  if(target==R.id.level25) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();;
                        while(buttonList.get(i).getId()==R.id.level25) {
                            i = i = (int) (Math.random() * buttonList.size());target=buttonList.get(i).getId();;
                        }
                        bdNext = findViewById(buttonList.get(i).getId());
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level26: { if(target==R.id.level26) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();;
                        while(buttonList.get(i).getId()==R.id.level26) {
                            i = i = (int) (Math.random() * buttonList.size());target=buttonList.get(i).getId();;
                        }
                        bdNext = findViewById(buttonList.get(i).getId());
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level27: { if(target==R.id.level27) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();;
                        while(buttonList.get(i).getId()==R.id.level27) {
                            i = i = (int) (Math.random() * buttonList.size());target=buttonList.get(i).getId();;
                        }
                        bdNext = findViewById(buttonList.get(i).getId());
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level28: {if(target==R.id.level28) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();;
                        while(buttonList.get(i).getId()==R.id.level28) {
                            i = i = (int) (Math.random() * buttonList.size());target=buttonList.get(i).getId();;
                        }
                        bdNext = findViewById(buttonList.get(i).getId());
                        bdNext.setBackgroundColor(Color.YELLOW);
                        score++;}
                        break;}
                    case R.id.level29: { if(target==R.id.level29) { bb.setBackgroundColor(Color.parseColor("#03A9F4"));
                        int i = (int)(Math.random()*buttonList.size());target=buttonList.get(i).getId();;
                        while(buttonList.get(i).getId()==R.id.level29) {
                            i = i = (int) (Math.random() * buttonList.size());target=buttonList.get(i).getId();;
                        }
                        bdNext = findViewById(buttonList.get(i).getId());
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

    }
}