package com.example.noteroomapp.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.noteroomapp.REPOSITORY
import com.example.noteroomapp.db.NoteDb
import com.example.noteroomapp.db.repository.NoteRealisation
import com.example.noteroomapp.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application){

    private val context = application

    fun initDb(){
        val daoNote = NoteDb.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealisation(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }



}