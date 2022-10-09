package com.example.mvvmfirebasenoteapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmfirebasenoteapp.data.source.repository.NoteRepository

class NoteViewModelFactory(
    val repository: NoteRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return super.create(modelClass)

        // TODO: Implement this is ViewModel doesn't work
    }
}