package com.shakibmansoori.miwok;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordsAdapter extends ArrayAdapter<Words> {
    private int mColorResourceId;

    public WordsAdapter(Activity context, ArrayList<Words> words) {

        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }


        Words currentWord = getItem(position);


        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_translaitonTv);

        miwokTextView.setText(currentWord.getMiwokTranslation());


        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_translaitonTv);

        defaultTextView.setText(currentWord.getDefaultTranslation());


        return listItemView;
    }
}
