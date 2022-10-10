package com.example.mvvmfirebasenoteapp.Note

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmfirebasenoteapp.data.model.Note
import com.example.mvvmfirebasenoteapp.databinding.ItemNoteLayoutBinding

class NoteListingAdapter(
    val onItemClicked: (Int, Note) -> Unit,
    val onEditClicked: (Int, Note) -> Unit,
    val onDeleteClicked: (Int, Note) -> Unit,
): RecyclerView.Adapter<NoteListingAdapter.NoteViewHolder>() {

    private var notesList: MutableList<Note> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notesList[position]
        holder.bind(note)
    }

    fun updateList(newList: MutableList<Note>) {
        this.notesList = newList
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        notesList.removeAt(position)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    inner class NoteViewHolder(val binding: ItemNoteLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            binding.tvNoteId.text = note.id
            binding.tvMsg.text = note.text
            binding.imgEdit.setOnClickListener{ onEditClicked.invoke(adapterPosition, note)}
            binding.imgDelete.setOnClickListener{ onDeleteClicked.invoke(adapterPosition, note)}
            binding.noteItemLayout.setOnClickListener{ onItemClicked.invoke(adapterPosition, note)}
        }
    }

}

