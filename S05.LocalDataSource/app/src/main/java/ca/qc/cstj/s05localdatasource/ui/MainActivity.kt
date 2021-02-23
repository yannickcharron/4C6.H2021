package ca.qc.cstj.s05localdatasource.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.s05localdatasource.R
import ca.qc.cstj.s05localdatasource.databinding.ActivityMainBinding
import ca.qc.cstj.s05localdatasource.repositories.ContactRepository
import ca.qc.cstj.s05localdatasource.ui.adapters.ContactRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val contactRepository = ContactRepository()
    private val contactRecyclerViewAdapter = ContactRecyclerViewAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcvContact.adapter = contactRecyclerViewAdapter
        binding.rcvContact.layoutManager = LinearLayoutManager(this)

        contactRepository.retrieveAll(25).asLiveData().observe(this, {
            contactRecyclerViewAdapter.contacts = it
            contactRecyclerViewAdapter.notifyDataSetChanged()
        })

    }
}