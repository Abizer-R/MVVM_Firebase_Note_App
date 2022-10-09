package com.example.mvvmfirebasenoteapp.Note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmfirebasenoteapp.R
import com.example.mvvmfirebasenoteapp.databinding.FragmentNoteListingBinding
import com.example.mvvmfirebasenoteapp.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListingFragment : Fragment() {

    private val TAG = NoteListingFragment::class.java.simpleName
    private lateinit var binding: FragmentNoteListingBinding
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteListingBinding.inflate(layoutInflater)

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        noteViewModel.getNotes()
        noteViewModel.notes.observe(viewLifecycleOwner) {
            // TODO: DUMMY DATA TESTING
            var dummy = ""
            it.forEach {
                dummy += "\n$it"
            }
            binding.tvTest.text = dummy
        }

        return binding.root
    }
}