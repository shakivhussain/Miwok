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

        words.add(new Words("father", "apa", R.drawable.family_father));
        words.add(new Words("mother", "ata", R.drawable.family_mother));
        words.add(new Words("son", "angsi", R.drawable.family_son));
        words.add(new Words("daughter", "tune", R.drawable.family_daughter));
        words.add(new Words("older brother", " taachi", R.drawable.family_older_brother));
        words.add(new Words("younger brother", "chalitti", R.drawable.family_younger_brother));
        words.add(new Words("older sister", "tete", R.drawable.family_older_sister));
        words.add(new Words("younger sister", "kollete", R.drawable.family_younger_sister));
        words.add(new Words("grand mother", "ama", R.drawable.family_grandmother));
        words.add(new Words("grand father", "apa", R.drawable.family_grandfather));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words, R.color.category_family);
        listView.setAdapter(adapter);

    }
}