package com.shakibmansoori.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;


    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        final ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("One", "Lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Words("Two", "Otiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Words("Three", "tolookasu", R.drawable.number_three, R.raw.number_three));
        words.add(new Words("Four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Words("Five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Words("Six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Words("Seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Words("Eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Words("Nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Words("Ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words, R.color.category_numbers);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words word = words.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getApplicationContext(), word.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });
    }
    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}