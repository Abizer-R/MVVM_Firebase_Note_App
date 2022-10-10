package com.example.mvvmfirebasenoteapp.Note

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmfirebasenoteapp.R
import com.example.mvvmfirebasenoteapp.databinding.FragmentNoteListingBinding
import com.example.mvvmfirebasenoteapp.util.Response
import com.example.mvvmfirebasenoteapp.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListingFragment : Fragment() {

    private val TAG = NoteListingFragment::class.java.simpleName
    private lateinit var binding: FragmentNoteListingBinding

    private val noteViewModel: NoteViewModel by viewModels()
    private val adapter = NoteListingAdapter(
        onItemClicked = { pos, note ->

        },
        onEditClicked = { pos, note ->

        },
        onDeleteClicked = { pos, note ->

        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteListingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        binding.rvNotesList.layoutManager = LinearLayoutManager(view.context)
        binding.rvNotesList.adapter = adapter

        binding.btnCreate.setOnClickListener {
            findNavController().navigate(R.id.action_noteListingFragment_to_noteDetailFragment)
        }

        noteViewModel.getNotes()
        noteViewModel.notes.observe(viewLifecycleOwner) { response ->
            when(response) {
                is Response.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Response.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Log.e(TAG, "onCreateView: ${response.errorMessage}", )
                }
                is Response.Success-> {
                    binding.progressBar.visibility = View.GONE
                    adapter.updateList(response.data!!.toMutableList())
                }
            }
        }
    }
}