package com.shakibmansoori.miwok;

import android.view.View;
import android.widget.Toast;

public class NumbersOnClickListeners implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "Hii", Toast.LENGTH_SHORT).show();
    }
}
