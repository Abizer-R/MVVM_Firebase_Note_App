package com.example.mvvmfirebasenoteapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmfirebasenoteapp.data.model.Note
import com.example.mvvmfirebasenoteapp.data.source.repository.NoteRepository
import com.example.mvvmfirebasenoteapp.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
): ViewModel() {

    private val _notes = MutableLiveData<Response<List<Note>>>()
    val notes: LiveData<Response<List<Note>>>
        get() = _notes

    private val _addNotes = MutableLiveData<Response<String>>()
    val addNotes: LiveData<Response<String>>
        get() = _addNotes

    fun getNotes() {
        _notes.value = Response.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            repository.getNotes {
                _notes.value = it
            }
        }
    }

    fun addNote(note: Note) {
        _addNotes.value = Response.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(note) {
                _addNotes.value = it
            }
        }
    }
}