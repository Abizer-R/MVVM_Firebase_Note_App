package com.example.mvvmfirebasenoteapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmfirebasenoteapp.data.model.Note
import com.example.mvvmfirebasenoteapp.data.source.repository.NoteRepository

class NoteViewModel(
    private val repository: NoteRepository
): ViewModel() {

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>>
        get() = _notes

    fun getNotes() {
        _notes.value = repository.getNotes()
    }
}