package com.example.noteroomapp.db.repository

import androidx.lifecycle.LiveData
import com.example.noteroomapp.model.NoteModel

interface NoteRepository {
    val allNotes : LiveData<List<NoteModel>>
    suspend fun insertNode(noteModel: NoteModel, onSuccess:() -> UInt )
    suspend fun deleteNode(noteModel: NoteModel, onSuccess:() -> UInt )

}