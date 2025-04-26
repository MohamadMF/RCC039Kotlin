package com.example.notesapp

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//CREATE TABLE note (_id INTEGER PRIMARY KEY AUTOINCREMENT, details TEXT)
@Parcelize
@Entity(tableName = "note")
class Note (
    @ColumnInfo(name = "_id") @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val details: String,
//    @ColumnInfo(name = "is_favorite")
//    val isFavorite: Boolean = false
) : Parcelable