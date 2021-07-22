package com.shakibmansoori.miwok;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("where are you going ?", "minto wuksus"));
        words.add(new Words("what is your name", "tinna oyaasina"));
        words.add(new Words("my name is", "oyyasit"));
        words.add(new Words("how are you feeling", "michaksas"));
        words.add(new Words("i'm feeling good", "kuchi achit"));
        words.add(new Words("Are you coming ", "aanas'aa"));
        words.add(new Words("yes , i'm coming", "haa'aanam"));
        words.add(new Words("i'm coming", "aanam"));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words);
        listView.setAdapter(adapter);


    }
}