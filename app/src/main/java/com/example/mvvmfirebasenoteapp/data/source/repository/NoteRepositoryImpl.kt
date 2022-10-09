package com.example.mvvmfirebasenoteapp.data.source.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmfirebasenoteapp.data.model.Note
import com.example.mvvmfirebasenoteapp.util.Response
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class NoteRepositoryImpl(
    val database: FirebaseFirestore
): NoteRepository {
    override fun getNotes(): Response<List<Note>> {
        // TODO: DUMMY DATA HARDCODED FOR TESTING
        val dummy = arrayListOf(
            Note("id1", "note1", Date()),
            Note("id2", "note2", Date()),
            Note("id3", "note3", Date()),
            Note("id4", "note4", Date())
        )

        if(dummy.isNullOrEmpty()) {
            return Response.Error("Data is empty")
        } else {
            return Response.Success(dummy)
        }
    }

}