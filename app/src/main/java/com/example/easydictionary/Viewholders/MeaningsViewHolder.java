package com.example.easydictionary.Viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easydictionary.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {

      public  TextView txtView_partsOfSpeech;
   public   RecyclerView recycler_definitions;
    public MeaningsViewHolder(@NonNull  View itemView) {
        super(itemView);

        txtView_partsOfSpeech = itemView.findViewById(R.id.txtView_partsOfSpeech);
        recycler_definitions = itemView.findViewById(R.id.recycler_definitions);
    }
}
