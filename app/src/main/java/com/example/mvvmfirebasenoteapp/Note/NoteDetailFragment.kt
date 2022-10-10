package com.example.mvvmfirebasenoteapp.Note

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmfirebasenoteapp.R
import com.example.mvvmfirebasenoteapp.data.model.Note
import com.example.mvvmfirebasenoteapp.databinding.FragmentNoteDetailBinding
import com.example.mvvmfirebasenoteapp.util.Response
import com.example.mvvmfirebasenoteapp.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class NoteDetailFragment : Fragment() {

    private val TAG = NoteDetailFragment::class.java.simpleName
    private lateinit var binding: FragmentNoteDetailBinding

    private val noteViewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding.btnCreate.setOnClickListener {
            if(binding.etNote.text.toString().isBlank()) {
                Toast.makeText(view.context, "Please Enter a message", Toast.LENGTH_SHORT).show()
            } else {
                noteViewModel.addNote(
                    Note(
                        id = "",
                        text = binding.etNote.text.toString(),
                        date = Date()
                    ))
            }
        }

        noteViewModel.addNotes.observe(viewLifecycleOwner) { response ->
            when(response) {
                is Response.Loading -> {
                    disableCreateBtn()
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Response.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Log.e(TAG, "onCreateView: ${response.errorMessage}", )
                }
                is Response.Success-> {
                    binding.progressBar.visibility = View.GONE
                    val msg = response.data
                    Toast.makeText(view.context, msg, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun disableCreateBtn() {
        binding.btnCreate.apply {
            isEnabled = false
            isClickable = false
        }
    }
}