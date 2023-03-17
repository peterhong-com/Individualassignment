package com.example.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Rank extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        Intent b =getIntent();
        int score = b.getIntExtra("score",0);
        String name=b.getStringExtra("name");
        System.out.println(b.getStringExtra("name"));
        TextView listContent = new TextView(this);
        Button Retry=new Button(this);
        Retry.setText("Retry");
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout l2= new LinearLayout(this);
        l2.setOrientation(LinearLayout.HORIZONTAL);
        TextView rank=new TextView(this);
        rank.setText("Score");
        TextView Name=new TextView(this);
        Name.setText("Name");
        Name.setPadding(100,0,0,0);
        l2.addView(rank);
        l2.addView(Name);
        ll.addView(l2);
        ll.addView(listContent);
        setContentView(ll);
        Score mySQLiteAdapter = new Score(this);
        mySQLiteAdapter.openToWrite();
        mySQLiteAdapter.insert(score,name);

        mySQLiteAdapter.close();
        mySQLiteAdapter = new Score(this);mySQLiteAdapter.openToRead();
        String contentRead = mySQLiteAdapter.queue25();
        mySQLiteAdapter.close();
        listContent.setText(contentRead);
        ll.setPadding(50,50,50,50);
        ll.addView(Retry);
        Retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ret=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(ret);
            }
        });

    }
}