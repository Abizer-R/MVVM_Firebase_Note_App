package com.example.mvvmfirebasenoteapp.Note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmfirebasenoteapp.R
import com.example.mvvmfirebasenoteapp.databinding.FragmentNoteListingBinding


class NoteListingFragment : Fragment() {

    private val TAG = NoteListingFragment::class.java.simpleName
    private lateinit var binding: FragmentNoteListingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteListingBinding.inflate(layoutInflater)
        return binding.root
    }
}