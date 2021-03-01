package ca.qc.cstj.s05localdatasource.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import ca.qc.cstj.s05localdatasource.R
import ca.qc.cstj.s05localdatasource.databinding.ActivityDatastoreBinding
import kotlinx.coroutines.launch

class DatastoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatastoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatastoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val firstName = binding.textInputLayout.editText!!.text.toString()
            val lastName = binding.textInputLayout2.editText!!.text.toString()


        }

        binding.btnOpen.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
        }

    }

}