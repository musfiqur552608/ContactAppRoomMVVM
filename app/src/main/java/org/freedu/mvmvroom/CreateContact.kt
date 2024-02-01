package org.freedu.mvmvroom

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.freedu.mvmvroom.databinding.ActivityCreateContactBinding

class CreateContact : AppCompatActivity() {
    // private variable to inflate the layout for the activity
    private lateinit var binding: ActivityCreateContactBinding

    // variable to access the ViewModel class
    val viewModel: ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveBtn.setOnClickListener {
            createContact(it)
        }
    }

    private fun createContact(it: View?) {
// read name and number from EditTexts
        val name = binding.cNameEt.text.toString()
        val number = binding.cnumberEt.text.toString()

        // create new contact object
        val data = Contacts(null, name = name, number = number)

        // call addContacts function from the ViewModel class
        viewModel.addContacts(data)

        // display a Toast message to confirm the save
        Toast.makeText(this@CreateContact, "Saved", Toast.LENGTH_SHORT).show()

        // start MainActivity
        startActivity(Intent(this@CreateContact, MainActivity::class.java))
    }
}