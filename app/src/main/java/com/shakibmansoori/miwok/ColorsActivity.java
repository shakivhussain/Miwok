package com.shakibmansoori.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("red","wetetti" ));
        words.add(new Words("mustard yellow","chiwiita"));
        words.add(new Words("dusty yellow","topiisa"));
        words.add(new Words("green","chokokki"));
        words.add(new Words("brown","takaakki"));
        words.add(new Words("gray","topoppi"));
        words.add(new Words("black","kululli"));
        words.add(new Words("white","kelilli"));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words);
        listView.setAdapter(adapter);

    }
}