package com.shakibmansoori.miwok;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("One", "Lutti"));
        words.add(new Words("Two", "Otiko"));
        words.add(new Words("Three", "tolookasu"));
        words.add(new Words("Four", "oyyisa"));
        words.add(new Words("Five", "massokka   "));
        words.add(new Words("Six", "temmokka"));
        words.add(new Words("Seven", "kenekaku"));
        words.add(new Words("Eight", "kawinta"));
        words.add(new Words("Nine", "wo'e"));
        words.add(new Words("Ten", "na'aacha"));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words);
        listView.setAdapter(adapter);
    }
}