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

        words.add(new Words("One", "Lutti", R.drawable.number_one));
        words.add(new Words("Two", "Otiko", R.drawable.number_two));
        words.add(new Words("Three", "tolookasu", R.drawable.number_three));
        words.add(new Words("Four", "oyyisa", R.drawable.number_four));
        words.add(new Words("Five", "massokka", R.drawable.number_five));
        words.add(new Words("Six", "temmokka", R.drawable.number_six));
        words.add(new Words("Seven", "kenekaku", R.drawable.number_seven));
        words.add(new Words("Eight", "kawinta", R.drawable.number_eight));
        words.add(new Words("Nine", "wo'e", R.drawable.number_nine));
        words.add(new Words("Ten", "na'aacha", R.drawable.number_ten));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words, R.color.category_numbers);
        listView.setAdapter(adapter);
    }
}