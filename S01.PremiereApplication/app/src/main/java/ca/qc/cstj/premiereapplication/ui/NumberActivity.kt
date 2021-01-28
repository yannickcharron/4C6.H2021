package ca.qc.cstj.premiereapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import ca.qc.cstj.premiereapplication.R
import ca.qc.cstj.premiereapplication.databinding.ActivityNumberBinding

class NumberActivity : AppCompatActivity() {

    //1. Variable pour la viewBinding
    private lateinit var binding: ActivityNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //2. Associer le xml de l'interface à la variable binding
        binding = ActivityNumberBinding.inflate(layoutInflater)
        //3. Afficher l'écran xml de l'interface du binding
        setContentView(binding.root)


        //Ajouter les nombres 0 à 100 dans le numberPicker
        //minValue = 0 par default
        binding.nprNumber.maxValue = 100

        //TODO: Choisir un nombre au hasard
        val theNumber = (0..100).random()
        Log.i("NumberActivity", theNumber.toString())

        //TODO: Évenement sur le clic du bouton
        binding.btnTry.setOnClickListener {

            val message = when {
                binding.nprNumber.value == theNumber -> {
                    "Bravo"
                }
                binding.nprNumber.value > theNumber -> {
                   "Plus petit"
                }
                else -> {
                    "Plus grand"
                }
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            val x = 4
            val validNumbers = listOf(0,4,6)
            when (x) {
                in 1..10 -> println("x is in the range")
                in validNumbers -> println("x is valid")
                !in 10..20 -> println("x is outside the range")
                else -> println("none of the above")
            }


        }



    }


}