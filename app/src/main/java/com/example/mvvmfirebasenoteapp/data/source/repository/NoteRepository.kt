package com.example.mvvmfirebasenoteapp.data.source.repository

import com.example.mvvmfirebasenoteapp.data.model.Note
import com.example.mvvmfirebasenoteapp.util.Response

interface NoteRepository {

    fun getNotes(): Response<List<Note>>
}