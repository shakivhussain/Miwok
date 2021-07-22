package com.shakibmansoori.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        final ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("red", "wetetti", R.drawable.color_red, R.raw.color_red));
        words.add(new Words("mustard yellow", "chiwiita", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Words("dusty yellow", "topiisa", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Words("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Words("brown", "takaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Words("gray", "topoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Words("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Words("white", "kelilli", R.drawable.color_white, R.raw.color_white));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words, R.color.category_colors);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words word = words.get(position);
                mediaPlayer = MediaPlayer.create(getApplicationContext(), word.getAudioResourceId());
                mediaPlayer.start();

            }
        });


    }
}