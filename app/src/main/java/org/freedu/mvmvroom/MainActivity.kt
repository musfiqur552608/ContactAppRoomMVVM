package org.freedu.mvmvroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.freedu.mvmvroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel : ContactViewModel  by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflate the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set onClickListener for the floating action button
        binding.addBtn.setOnClickListener{
            val intent = Intent(this , CreateContact::class.java)
            startActivity(intent)
        }

        // Observe the LiveData returned by the getAllContacts method
        viewModel.getAllContacts().observe(this , Observer {  list->
            // set the layout manager and the adapter for the recycler view
            binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            binding.recyclerView.adapter = ContactsAdapter(this,list)
        })
    }
}