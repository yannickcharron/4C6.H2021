package ca.qc.cstj.s05localdatasource.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ca.qc.cstj.s05localdatasource.R
import ca.qc.cstj.s05localdatasource.databinding.ActivityMainBinding
import ca.qc.cstj.s05localdatasource.helpers.AppDatabase
import ca.qc.cstj.s05localdatasource.models.Contact
import ca.qc.cstj.s05localdatasource.repositories.ContactRepository
import ca.qc.cstj.s05localdatasource.ui.adapters.ContactRecyclerViewAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), ContactRecyclerViewAdapter.OnContactListener {
    private lateinit var binding: ActivityMainBinding

    //private val contactRepository = ContactRepository() //Accès aux données locales ou distances
    private val contactRecyclerViewAdapter = ContactRecyclerViewAdapter(listOf(), this) //Présentation des données dans le RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcvContact.adapter = contactRecyclerViewAdapter
        binding.rcvContact.layoutManager = LinearLayoutManager(this)
        //binding.rcvContact.layoutManager = GridLayoutManager(this, 2)

        //touchCallBack
        val touchCallback = ItemTouchHelper(contactRecyclerViewAdapter.itemTouchHelperCallback)
        touchCallback.attachToRecyclerView(binding.rcvContact)

        AppDatabase.getInstance(this).contactRepository().retrieveAll().asLiveData().observe(this, {
            contactRecyclerViewAdapter.contacts = it
            contactRecyclerViewAdapter.notifyDataSetChanged()
        })

        binding.fabAdd.setOnClickListener {

            val contact = Contact("Test", "Test", true)
            //Démarrage d'une action asynchrone = Coroutine
            lifecycleScope.launch {
                //Sur un autre Thread
                AppDatabase.getInstance(this@MainActivity).contactRepository().insert(contact)
            }

        }

    }

    override fun onSwipeRight(contact: Contact) {
        lifecycleScope.launch {
            //Sur un autre Thread
            AppDatabase.getInstance(this@MainActivity).contactRepository().delete(contact.idContact)
        }
    }

    override fun onSwipeLeft(contact: Contact) {

        //Update
        //Faire les modifications
        contact.firstName = "Rémi"
        contact.isOnline = !contact.isOnline
        lifecycleScope.launch {
            AppDatabase.getInstance(this@MainActivity).contactRepository().update(contact)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}