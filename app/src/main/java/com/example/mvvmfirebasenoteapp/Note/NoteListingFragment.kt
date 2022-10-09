package com.example.mvvmfirebasenoteapp.Note

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmfirebasenoteapp.R
import com.example.mvvmfirebasenoteapp.databinding.FragmentNoteListingBinding
import com.example.mvvmfirebasenoteapp.util.Response
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
        noteViewModel.notes.observe(viewLifecycleOwner) { response ->
            // TODO: DUMMY DATA TESTING
            when(response) {
                is Response.Loading -> {
                    Log.i(TAG, "onCreateView: Loading")
                }
                is Response.Success-> {
                    var dummy = ""
                    response.data?.forEach {
                        dummy += "\n$it"
                    }
                    binding.tvTest.text = dummy
                }
                is Response.Error -> {
                    Log.e(TAG, "onCreateView: ${response.errorMessage}", )
                }
            }
        }

        return binding.root
    }
}