package com.example.mvvmfirebasenoteapp.data.source.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmfirebasenoteapp.data.model.Note

class NoteRepositoryImpl: NoteRepository {
    override fun getNotes(): List<Note> {
        return arrayListOf()
    }

}