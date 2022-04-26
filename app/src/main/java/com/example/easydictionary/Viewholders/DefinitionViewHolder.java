package com.example.easydictionary.Viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easydictionary.R;

public class DefinitionViewHolder  extends RecyclerView.ViewHolder {
    public TextView txtView_Definition, txtView_example,txtView_synonyms,txtView_antonyms;

    public DefinitionViewHolder(@NonNull  View itemView) {
        super(itemView);
        txtView_Definition = itemView.findViewById(R.id.txtView_Definition);
        txtView_example = itemView.findViewById(R.id.txtView_example);
        txtView_synonyms = itemView.findViewById(R.id.txtView_synonyms);
        txtView_antonyms = itemView.findViewById(R.id.txtView_antonyms);
    }
}
