package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert

@Dao
interface NoteDAO {

    //INSERT INTO note (details) VALUES (foo)
    @Insert
    fun saveNote(n: Note)

    //UPDATE note
    @Update
    fun updateNote(n: Note)

    @Upsert
    fun upsertNote(n: Note)

    //SELECT * FROM note
    @Query("SELECT * FROM note")
    fun getNotes(): LiveData<List<Note>>

    //DELETE FROM note WHERE _id == 1
    @Delete
    fun deleteNote(n: Note)
}