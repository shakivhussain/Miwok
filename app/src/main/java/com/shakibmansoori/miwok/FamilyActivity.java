package com.shakibmansoori.miwok;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("father", "apa"));
        words.add(new Words("mother", "ata"));
        words.add(new Words("son", "angsi"));
        words.add(new Words("daughter", "tune"));
        words.add(new Words("older brother", " taachi"));
        words.add(new Words("younger brother", "chalitti"));
        words.add(new Words("older sister", "tete"));
        words.add(new Words("younger sister", "kollete"));
        words.add(new Words("grand mother", "ama"));
        words.add(new Words("grand father", "apa"));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words);
        listView.setAdapter(adapter);

    }
}