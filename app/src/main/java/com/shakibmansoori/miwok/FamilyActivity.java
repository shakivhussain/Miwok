package com.shakibmansoori.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        final ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("father", "apa", R.drawable.family_father, R.raw.family_father));
        words.add(new Words("mother", "ata", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Words("son", "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Words("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Words("older brother", " taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Words("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Words("older sister", "tete", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Words("younger sister", "kollete", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Words("grand mother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Words("grand father", "apa", R.drawable.family_grandfather, R.raw.family_grandfather));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words, R.color.category_family);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words word = words.get(position);
                mediaPlayer = MediaPlayer.create(getApplicationContext(), word.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });

            }
        });


    }

    private void releaseMediaPlayer() {

        if (mediaPlayer != null) {
            mediaPlayer.release();

            mediaPlayer = null;
        }
    }
}