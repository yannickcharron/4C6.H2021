package ca.qc.cstj.s05localdatasource.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import ca.qc.cstj.s05localdatasource.R
import ca.qc.cstj.s05localdatasource.databinding.ActivityDatastoreBinding
import ca.qc.cstj.s05localdatasource.models.User
import ca.qc.cstj.s05localdatasource.repositories.UserRepository
import kotlinx.coroutines.launch

class DatastoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatastoreBinding
    private lateinit var userRepository: UserRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatastoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepository = UserRepository(this)

        userRepository.user.asLiveData().observe(this, {
            //Mettre à jour les données de l'utilisateur (Nom et Image en ligne ou non)
            binding.tilFirstName.editText!!.setText(it.firstName)
            binding.tilLastName.editText!!.setText(it.lastName)
            binding.swtOnline.isChecked = it.isOnline

            //Nom et image
            @SuppressLint("SetTextI18n")
            binding.txvUserName.text = "${it.firstName} ${it.lastName}"

            when(it.isOnline) {
                true -> {
                    binding.imgUserIsOnline.setImageResource(R.drawable.ic_baseline_cloud_24)
                }
                false -> {
                    binding.imgUserIsOnline.setImageResource(R.drawable.ic_baseline_cloud_off_24)
                }
            }

        })

        binding.btnSave.setOnClickListener {
            val firstName = binding.tilFirstName.editText!!.text.toString()
            val lastName = binding.tilLastName.editText!!.text.toString()

            lifecycleScope.launch {
                userRepository.update(firstName, lastName, binding.swtOnline.isChecked)
            }

        }

        binding.btnOpen.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
        }

    }

}