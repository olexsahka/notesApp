package com.example.noteroomapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteroomapp.db.dao.NoteDao
import com.example.noteroomapp.model.NoteModel


@Database(entities = [NoteModel:: class], version = 1) //  после изменения необъодимо поменять версию
abstract class NoteDb : RoomDatabase() {
    abstract fun getNoteDao() : NoteDao


    companion object{
        private var database : NoteDb ?= null


        @Synchronized
        fun getInstance(context: Context):NoteDb{
            return if (database == null){
                database = Room.databaseBuilder(context,NoteDb ::class.java,"db").build()
                database as NoteDb
            }
            else{
                return database as NoteDb
            }
        }
    }
}