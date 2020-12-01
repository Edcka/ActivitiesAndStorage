package com.example.activitiesandstorage;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.view.View;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.activitiesandstorage.ui.main.Note;


public class AddNoteActivity extends AppCompatActivity {


    EditText textName, textContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        this.textName = findViewById(R.id.textName);
        this.textContent = findViewById(R.id.textContent);
    }

    public void onButtonDone(View view){
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor note = sharedPref.edit();
                note.putString(Note.BASE_NOTE_KEY, textName.getText().toString());
                note.putString(Note.BASE_NOTE_CONTENT,textContent.getText().toString());
                note.commit();
                finish();
    }

}
