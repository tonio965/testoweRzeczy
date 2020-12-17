package com.example.myapplication22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication22.model.Note;
import com.example.myapplication22.model.NoteViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private NoteViewModel noteViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(NoteViewModel.class);

        noteViewModel.getAll().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                //update recycler
                Toast.makeText(MainActivity.this,"onChanged" + noteViewModel.getAll().getValue().size() , Toast.LENGTH_SHORT).show();
                if(noteViewModel.getAll().getValue().size()==0){
                    noteViewModel.insert(new Note("tit",3,"desctest"));
                    Toast.makeText(MainActivity.this,"added" + noteViewModel.getAll().getValue().size() , Toast.LENGTH_SHORT).show();

                }
            }
        });


        Intent intent = new Intent(this,MyService.class);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            startForegroundService(intent);
        else{
            startService(intent);
        }
    }

    public void startMethod(View view) {
        startService(new Intent(this, MyService.class));
    }

    public void stopMethod(View view) {
        stopService(new Intent(this, MyService.class));
    }
}