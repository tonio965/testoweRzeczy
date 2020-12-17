package com.example.myapplication22.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "note")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private int priority;

    private String description;


    public Note(String title, int priority, String description) {
        this.title = title;
        this.priority = priority;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
