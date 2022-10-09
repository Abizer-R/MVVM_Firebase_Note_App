package com.example.mvvmfirebasenoteapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmfirebasenoteapp.data.model.Note
import com.example.mvvmfirebasenoteapp.data.source.repository.NoteRepository
import com.example.mvvmfirebasenoteapp.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
): ViewModel() {

    private val _notes = MutableLiveData<Response<List<Note>>>()
    val notes: LiveData<Response<List<Note>>>
        get() = _notes

    fun getNotes() {
        _notes.value = repository.getNotes()
    }
}