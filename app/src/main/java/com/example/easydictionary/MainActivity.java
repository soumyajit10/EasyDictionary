package com.example.easydictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easydictionary.Adapters.MeaningAdapter;
import com.example.easydictionary.Adapters.PhoneticsAdapter;
import com.example.easydictionary.Models.APIResponse;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    TextView textView_Word;
    RecyclerView Recycler_phonetics,Recycler_meanings;
    ProgressDialog progressDialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningAdapter meaningAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        textView_Word = findViewById(R.id.textView_word);
        Recycler_phonetics = findViewById(R.id.Recycler_phonetics);
        Recycler_meanings = findViewById(R.id.Recycler_meanings);
        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Loading...");
        progressDialog.show();
        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getWordMeaning(listener,"welcome");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching Results for " +query);
                progressDialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getWordMeaning(listener,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }

    private  final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            progressDialog.dismiss();
            if (apiResponse==null){
                Toast.makeText(MainActivity.this,"No Data Found",Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiResponse);
        }

        @Override
        public void OnError(String message) {

            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message ,Toast.LENGTH_SHORT).show();

        }
    };

    private void showData(APIResponse apiResponse) {
        textView_Word.setText("Word: " + apiResponse.getWord());

        Recycler_phonetics.setHasFixedSize(true);
        Recycler_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter = new PhoneticsAdapter(this,apiResponse.getPhonetics());
        Recycler_phonetics.setAdapter(phoneticsAdapter);

        Recycler_meanings.setHasFixedSize(true);
        Recycler_meanings.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter = new MeaningAdapter(this,apiResponse.getMeanings());
        Recycler_meanings.setAdapter(meaningAdapter);


    }


}

