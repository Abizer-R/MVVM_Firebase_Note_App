package com.example.mvvmfirebasenoteapp.data.source.repository

import com.example.mvvmfirebasenoteapp.data.model.Note

interface NoteRepository {

    fun getNotes(): List<Note>
}