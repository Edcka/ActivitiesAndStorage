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

    /* if (notes.size() == -1) {

         notes.add(new Note("Example name", "Example Content"));
         arrayAdapter.notifyDataSetChanged();
         // } else {
         //     notes = new ArrayList(set);
         // }

         // Using custom listView Provided by Android Studio
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {*/
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
        String name = sharedPref.getString(Note.BASE_NOTE_KEY,"Text");
        arrayAdapter.add(name);
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


    /*@Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Going from MainActivity to NotesEditorActivity
        Intent intent = new Intent(getApplicationContext(), AddNoteActivity.class);
        intent.putExtra("noteId", i);
        startActivity(intent);

    };*/


       /* listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int itemToDelete = i;
                // To delete the data from the App
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this note?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                notes.remove(itemToDelete);
                                arrayAdapter.notifyDataSetChanged();
                                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
                                HashSet<String> set = new HashSet(MainActivity.notes);
                                sharedPreferences.edit().putStringSet("notes", set).apply();
                            }
                        }).setNegativeButton("No", null).show();
                return true;
            }
        });

        */

