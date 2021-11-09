package com.mizu.viewmodellivedatasamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private lateinit var dataEditText: EditText
    private lateinit var updateButton: Button
    private lateinit var deleteButton: Button
    private lateinit var dataTextView: TextView

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataEditText = findViewById(R.id.data_edit_text)
        updateButton = findViewById(R.id.update_button)
        deleteButton = findViewById(R.id.delete_button)
        dataTextView = findViewById(R.id.data_text_view)

        updateButton.setOnClickListener {
            val text = dataEditText.text.toString()
            viewModel.addItem(text)
        }

        deleteButton.setOnClickListener {
            val text = dataEditText.text.toString()
            viewModel.deleteItem(text)
        }

        // Make this activity observe the text subject for changes
        /*viewModel.getText().observe(this) { text ->
            dataTextView.text = text
        }*/

        // Make this activity observe the items subject for changes
        viewModel.getItems().observe(this) { items ->
            dataTextView.text = ""
            for (item in items) {
                dataTextView.append("$item\n")
            }
        }
    }
}