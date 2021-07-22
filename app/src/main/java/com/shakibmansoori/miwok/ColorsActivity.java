package com.shakibmansoori.miwok;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("red", "wetetti", R.drawable.color_red));
        words.add(new Words("mustard yellow", "chiwiita", R.drawable.color_mustard_yellow));
        words.add(new Words("dusty yellow", "topiisa", R.drawable.color_dusty_yellow));
        words.add(new Words("green", "chokokki", R.drawable.color_green));
        words.add(new Words("brown", "takaakki", R.drawable.color_brown));
        words.add(new Words("gray", "topoppi", R.drawable.color_gray));
        words.add(new Words("black", "kululli", R.drawable.color_black));
        words.add(new Words("white", "kelilli", R.drawable.color_white));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words);
        listView.setAdapter(adapter);

    }
}