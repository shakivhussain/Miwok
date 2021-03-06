package com.shakibmansoori.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK) {
                //pause playback
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                //resume playback
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {

                //stop playback
                releaseMediaPlayer();
            }
        }
    };

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

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("where are you going ?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Words("what is your name", "tinna oyaasina", R.raw.phrase_what_is_your_name));
        words.add(new Words("my name is", "oyyasit", R.raw.phrase_my_name_is));
        words.add(new Words("how are you feeling", "michaksas", R.raw.phrase_how_are_you_feeling));
        words.add(new Words("i'm feeling good", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Words("Are you coming ", "aanas'aa", R.raw.phrase_are_you_coming));
        words.add(new Words("yes , i'm coming", "haa'aanam", R.raw.phrase_yes_im_coming));
        words.add(new Words("i'm coming", "aanam", R.raw.phrase_im_coming));

        ListView listView = findViewById(R.id.numberListV);

        // we cant implement custom arraylist to the default adapter , so create custom arraAdapter
        WordsAdapter adapter = new WordsAdapter(this, words, R.color.category_phrases);
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
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}