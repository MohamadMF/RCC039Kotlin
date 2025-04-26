package com.example.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class NoteViewModel(app: Application) : AndroidViewModel(app) {
    private val db = RoomDBHelper.getInstance(app)

    fun upsert(note: Note) = db.dao.upsertNote(note)
    fun delete(note: Note) = db.dao.deleteNote(note)
    fun getNotes() = db.dao.getNotes()
    fun deleteAllNotes() = db.dao.deleteAll()
}