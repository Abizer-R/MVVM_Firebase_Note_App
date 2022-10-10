package com.example.mvvmfirebasenoteapp.data.source.repository

import com.example.mvvmfirebasenoteapp.data.model.Note
import com.example.mvvmfirebasenoteapp.util.Response

interface NoteRepository {

    suspend fun getNotes(result: (Response<List<Note>>) -> Unit)

    suspend fun addNote(note: Note, result: (Response<String>) -> Unit)
}