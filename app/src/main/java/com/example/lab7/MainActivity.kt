package com.example.lab7

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editNote: EditText
    private lateinit var btnSave: Button
    private lateinit var btnLoad: Button
    private val fileName = "note.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNote = findViewById(R.id.edit_note)
        btnSave = findViewById(R.id.btn_save)
        btnLoad = findViewById(R.id.btn_load)

        btnSave.setOnClickListener {
            saveNote()
        }

        btnLoad.setOnClickListener {
            loadNote()
        }
    }

    private fun saveNote() {
        val data = editNote.text.toString()
        try {
            openFileOutput(fileName, Context.MODE_PRIVATE).bufferedWriter().use { writer ->
                writer.write(data)
            }
            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error saving note", Toast.LENGTH_SHORT).show()
        }
    }


}