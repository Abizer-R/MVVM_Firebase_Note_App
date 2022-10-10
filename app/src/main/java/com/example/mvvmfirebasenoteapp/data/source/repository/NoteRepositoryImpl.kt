package com.example.mvvmfirebasenoteapp.data.source.repository

import android.app.appsearch.GlobalSearchSession
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmfirebasenoteapp.data.model.Note
import com.example.mvvmfirebasenoteapp.util.FireStoreTables
import com.example.mvvmfirebasenoteapp.util.Response
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.util.*

class NoteRepositoryImpl(
    private val database: FirebaseFirestore
): NoteRepository {

    override suspend fun getNotes(result: (Response<List<Note>>) -> Unit) {
        withContext(Dispatchers.IO) {
            val data = database.collection(FireStoreTables.NOTE)
                .get()
                .addOnSuccessListener { ss ->
                    val notesList = arrayListOf<Note>()
                    for(note in ss) {
                        val currNote = note.toObject(Note::class.java)
                        notesList.add(currNote)
                    }
                    result.invoke(Response.Success(notesList))
                }
                .addOnFailureListener {
                    result.invoke(Response.Error(it.localizedMessage))
                }
        }
    }

    // We pass string because we will return the ID of our newly formed note
    override suspend fun addNote(note: Note, result: (Response<String>) -> Unit) {
        withContext(Dispatchers.IO) {
            // We want to include the id of our new note in its data too
            val newNoteRef = database.collection(FireStoreTables.NOTE).document()

            // updating the id of our 'note' object
            note.id = newNoteRef.id

            newNoteRef.set(note)
                .addOnSuccessListener {
                    result.invoke(Response.Success("Note Added Successfully"))
                }
                .addOnFailureListener {
                    result.invoke(Response.Error(it.localizedMessage))
                }
        }
    }
}