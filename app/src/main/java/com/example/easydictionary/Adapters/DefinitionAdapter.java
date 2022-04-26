package com.example.easydictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easydictionary.Models.Definitions;
import com.example.easydictionary.R;
import com.example.easydictionary.Viewholders.DefinitionViewHolder;

import java.util.List;

public class  DefinitionAdapter  extends RecyclerView.Adapter<DefinitionViewHolder> {

    private Context context;
    List<Definitions> definitionsList;

    public DefinitionAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull

    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  DefinitionViewHolder holder, int position) {
        holder.txtView_Definition.setText("Definition: "+ definitionsList.get(position).getDefinition());
        holder.txtView_example.setText("Example: " + definitionsList.get(position).getExample());
        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();
        synonyms.append(definitionsList.get(position).getSynonyms());
        antonyms.append(definitionsList.get(position).getAntonyms());
        holder.txtView_synonyms.setText(synonyms);
        holder.txtView_antonyms.setText(antonyms);
        holder.txtView_synonyms.setSelected(true);
        holder.txtView_antonyms.setSelected(true);


    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
