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
                SharedPreferences.Editor name = sharedPref.edit();
                SharedPreferences.Editor content = sharedPref.edit();
                name.putString(Note.BASE_NOTE_KEY, textName.getText().toString());
                content.putString(Note.BASE_NOTE_CONTENT, textContent.getText().toString());
                name.apply();
                content.apply();
                finish();
    }

}

        // Fetch data that is passed from MainActivity

        // Accessing the data using key and value
        //noteId = intent.getIntExtra("noteId", -1);
        // if (noteId != -1) {
        // editText.setText(MainActivity.notes.get(noteId));
        // MainActivity.notes.add(new MainActivity.Note("",""));
        //noteId = MainActivity.notes.size() - 1;
        //MainActivity.arrayAdapter.notifyDataSetChanged();
        // }



        /*editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // add your code here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.notes.set(noteId, String.valueOf(charSequence));
                MainActivity.arrayAdapter.notifyDataSetChanged();
                // Creating Object of SharedPreferences to store data in the phone
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
                HashSet set = new HashSet(MainActivity.notes);
                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // add your code here
            }
        });
        */