package com.example.notesapp

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class RoomDBHelper : RoomDatabase() {
    abstract val dao: NoteDAO

    //Single-ton : DesignPattern (privateConstructor, getInstance) _
    // in Database is only 50% because Database already need publicConstructor.
    //We make 'companion object' keyword to be able to make a copy from _
    // current class out it without needing to add val or var (copy) from it _
    // that like static keyword
    companion object {
        @Volatile //any read or write will be already available always
        private var INSTANCE: RoomDBHelper? = null //this is what we need

        fun getInstance(context: Context): RoomDBHelper {
            // ?: Elvis mean
            // ?(try to return object) and
            // :(if you couldn't, please do after :...)
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, RoomDBHelper::class.java, "MyDB")
                    .allowMainThreadQueries() //Coroutine is better
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    /*
    companion object {
        @Volatile
        private var INSTANCE: RoomDBHelper? = null

        fun getInstance(context: Context): RoomDBHelper {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room
                    .databaseBuilder(context, RoomDBHelper::class.java, "MyDB")
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }

     */
}