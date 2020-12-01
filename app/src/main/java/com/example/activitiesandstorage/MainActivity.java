package com.example.activitiesandstorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activitiesandstorage.ui.main.Note;

import java.util.ArrayList;

import static com.example.activitiesandstorage.R.*;
import static com.example.activitiesandstorage.R.layout.*;

public class MainActivity extends AppCompatActivity {



    ArrayList<String> notes = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        listView = findViewById(id.listView);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);

        return true;
    }


    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sharedPref.getString(Note.BASE_NOTE_KEY,"Header");
        String content = sharedPref.getString(Note.BASE_NOTE_CONTENT,"Content");
        arrayAdapter.clear();
        arrayAdapter.add(name +"\n" + content);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId() == id.add_note){
            Intent intent = new Intent(this, AddNoteActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent1 = new Intent(this, DeleteNoteActivity.class);
            startActivity(intent1);

        }
        return true;
    }
}


