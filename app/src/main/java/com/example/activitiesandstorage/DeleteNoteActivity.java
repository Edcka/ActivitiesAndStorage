package com.example.activitiesandstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.activitiesandstorage.ui.main.Note;

import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity {

    ArrayList<String> notes = new ArrayList<>();
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        spinner= findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.note_name_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        String name = sharedPref.getString(Note.BASE_NOTE_KEY,"Text");
        adapter.add(name);
        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }


}