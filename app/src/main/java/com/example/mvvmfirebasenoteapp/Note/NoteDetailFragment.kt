package com.example.mvvmfirebasenoteapp.Note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmfirebasenoteapp.R
import com.example.mvvmfirebasenoteapp.databinding.FragmentNoteDetailBinding

// TODO: Rename parameter arguments, choose names that match
class NoteDetailFragment : Fragment() {

    private val TAG = NoteDetailFragment::class.java.simpleName
    private lateinit var binding: FragmentNoteDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteDetailBinding.inflate(layoutInflater)
        return binding.root
    }
}