package com.example.noteroomapp.db.repository

import androidx.lifecycle.LiveData
import com.example.noteroomapp.db.dao.NoteDao
import com.example.noteroomapp.model.NoteModel

class NoteRealisation(private val noteDao: NoteDao) : NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNode(noteModel: NoteModel, onSuccess: () -> UInt) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNode(noteModel: NoteModel, onSuccess: () -> UInt) {
        noteDao.delete(noteModel)
    }
}