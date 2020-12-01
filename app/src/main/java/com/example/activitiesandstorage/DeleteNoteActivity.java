package com.example.activitiesandstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.activitiesandstorage.ui.main.Note;

import java.util.ArrayList;
import java.util.List;


public class DeleteNoteActivity extends AppCompatActivity {
    ArrayList<String> names = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    Spinner spinner;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletion);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        spinner = findViewById(R.id.spinner);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, names );
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);


        String name = sharedPref.getString(Note.BASE_NOTE_KEY,"Text");
        arrayAdapter.add(name);
    }

 /*
 NGL labai ilgai uztrukau, kol man smegenai uzkrove, kad tas SharedPrefference po 1 struct
 saugo ir viskas, nes nenaudojau sito niekad,norejau ismokt, bet dieve mano.
  */
    public void onButtonDelete(View view) {
            SharedPreferences.Editor name = sharedPref.edit();
            name.remove(Note.BASE_NOTE_KEY);
            name.remove(Note.BASE_NOTE_CONTENT);
            name.commit();
            finish();
        }
    }
