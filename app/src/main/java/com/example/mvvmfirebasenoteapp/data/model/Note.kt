package com.example.mvvmfirebasenoteapp.data.model

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class Note(
    var id: String = "",    // It will be changed to the document ID in repositoryImpl addnote()
    val text: String = "",
    @ServerTimestamp
    val date: Date = Date()
)
