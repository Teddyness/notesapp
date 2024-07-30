package com.example.notesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AddNoteFragment : Fragment() {

    private val notes = mutableListOf<Note>()
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_note, container, false)

        val etTitle = view.findViewById<EditText>(R.id.etTitle)
        val spinnerPriority = view.findViewById<Spinner>(R.id.spinnerPriority)
        val btnSave = view.findViewById<Button>(R.id.btnSave)
        val btnClear = view.findViewById<Button>(R.id.btnClear)
        val rvNotes = view.findViewById<RecyclerView>(R.id.rvNotes)

        noteAdapter = NoteAdapter(notes)
        rvNotes.adapter = noteAdapter
        rvNotes.layoutManager = LinearLayoutManager(context)

        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val priority = spinnerPriority.selectedItem.toString()

            if (title.isNotEmpty()) {
                val newNote = Note(title, priority)
                notes.add(newNote)
                noteAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(requireContext(), "Please enter a title", Toast.LENGTH_SHORT).show()
            }
        }

        btnClear.setOnClickListener {
            notes.clear()
            noteAdapter.notifyDataSetChanged()
            Toast.makeText(requireContext(), "All notes cleared", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
