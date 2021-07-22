package com.shakibmansoori.miwok;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("One", "Lutti"));
        words.add(new Words("One", "Lutti"));
        words.add(new Words("One", "Lutti"));
        words.add(new Words("One", "Lutti"));
        words.add(new Words("One", "Lutti"));
        words.add(new Words("One", "Lutti"));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words);
        listView.setAdapter(adapter);
    }
}