package com.example.mvvmfirebasenoteapp.di

import com.example.mvvmfirebasenoteapp.data.source.repository.NoteRepository
import com.example.mvvmfirebasenoteapp.data.source.repository.NoteRepositoryImpl
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RespositoryModule {

    @Provides
    @Singleton
    fun provideNoteRepository(database: FirebaseFirestore): NoteRepository {
        return NoteRepositoryImpl(database)
    }
}