package com.example.notesapp

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.fragment.app.DialogFragment

class ReminderDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_reminder, null)

        val btnSetReminder = view.findViewById<Button>(R.id.btnSetReminder)

        btnSetReminder.setOnClickListener {
            // Set reminder logic here
            dismiss()
        }

        return Dialog(requireContext()).apply {
            setContentView(view)
            setTitle("Set Reminder")
        }
    }
}
