package com.example.noteroomapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteroomapp.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NoteModel)

    @Delete
    suspend fun delete(noteModel: NoteModel)

    @Query("SELECT * from note_table")
    fun getAllNotes() :LiveData<List<NoteModel>>
}