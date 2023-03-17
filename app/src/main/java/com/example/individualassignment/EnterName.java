package com.example.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterName extends AppCompatActivity {

    EditText name;
    Button next;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);
        Intent a = getIntent();
        score=a.getIntExtra("score",0);
        name=findViewById(R.id.Name);

        next=findViewById(R.id.Next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(name.getText()).equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter the name",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent b = new Intent(getApplicationContext(),Rank.class);
                    b.putExtra("score",score);
                    b.putExtra("name",String.valueOf(name.getText()));
                    startActivity(b);
                }
            }
        });
    }
}