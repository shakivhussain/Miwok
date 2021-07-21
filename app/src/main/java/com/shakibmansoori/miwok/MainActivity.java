package com.shakibmansoori.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numbersTv, familyTv, colorsTv, phrasesTv;

        numbersTv = findViewById(R.id.numbersActiviyt);
        familyTv = findViewById(R.id.familyActiviyt);
        colorsTv = findViewById(R.id.colorsActiviyt);
        phrasesTv = findViewById(R.id.phrasesActiviyt);

        numbersTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NumbersActivity.class);
                startActivity(intent);
            }
        });
        familyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FamilyActivity.class);
                startActivity(intent);
            }
        });
        colorsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ColorsActivity.class);
                startActivity(intent);
            }
        });
        phrasesTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhrasesActivity.class);
                startActivity(intent);
            }
        });

    }
}