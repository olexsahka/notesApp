package com.example.noteroomapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table") //  Аннотация
class NoteModel (

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    var tittle :String = "",

    @ColumnInfo
    var description : String = ""
)