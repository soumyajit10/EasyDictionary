package com.example.easydictionary.Viewholders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easydictionary.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {
    public TextView txtView_phonetic;
    public ImageButton imageBtn_audio;
    public PhoneticViewHolder(@NonNull  View itemView) {
        super(itemView);

        txtView_phonetic = itemView.findViewById(R.id.txtView_phonetic);
        imageBtn_audio = itemView.findViewById(R.id.imageBtn_audio);
    }
}
