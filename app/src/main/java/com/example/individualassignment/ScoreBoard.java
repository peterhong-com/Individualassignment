package com.example.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        TextView listContent = new TextView(this);
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
        mySQLiteAdapter.openToRead();
        String contentRead = mySQLiteAdapter.queue25();
        mySQLiteAdapter.close();
        listContent.setText(contentRead);
        ll.setPadding(50,50,50,50);
    }
}