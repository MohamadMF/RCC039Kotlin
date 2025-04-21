package com.example.notesapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//CREATE TABLE note (_id INTEGER PRIMARY KEY AUTOINCREMENT, details TEXT)
@Entity(tableName = "note")
class Note (
    @ColumnInfo(name = "_id") @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val details: String
)