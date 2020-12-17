package com.example.myapplication22.model;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM Note")
    void deleteAllNotes();

    @Query("SELECT * FROM Note order by priority DESC")
    LiveData<List<Note>>  getAllNotes();



}

