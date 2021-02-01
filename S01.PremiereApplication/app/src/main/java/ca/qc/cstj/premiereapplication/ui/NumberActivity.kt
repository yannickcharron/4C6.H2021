package ca.qc.cstj.premiereapplication.ui

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import ca.qc.cstj.premiereapplication.R
import ca.qc.cstj.premiereapplication.databinding.ActivityNumberBinding

const val MAX_ATTEMPTS = 5

class NumberActivity : AppCompatActivity() {

    //1. Variable pour la viewBinding
    private lateinit var binding: ActivityNumberBinding
    private var attempts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //2. Associer le xml de l'interface à la variable binding
        binding = ActivityNumberBinding.inflate(layoutInflater)
        //3. Afficher l'écran xml de l'interface du binding
        setContentView(binding.root)

        //Ajouter les nombres 0 à 100 dans le numberPicker
        //minValue = 0 par default
        binding.nprNumber.maxValue = 100
        binding.txvAttempts.text = "Il reste ${(MAX_ATTEMPTS - attempts)} essais"
        binding.txvPlayer.text = getString(R.string.number_guest_text, intent.getStringExtra(INTENT_EXTRA_PLAYER_NAME))

        //binding.txvPlayer.text = "Devines le nombre ${intent.getStringExtra(INTENT_EXTRA_PLAYER_NAME)}"

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
            if (attempts == MAX_ATTEMPTS - 1) {
                Toast.makeText(this, "Vous avez perdu!!!", Toast.LENGTH_LONG).show()
                binding.btnTry.visibility = View.INVISIBLE
                finish()
            } else if (attempts == MAX_ATTEMPTS - 2) {
                binding.txvAttempts.setTextColor(Color.RED)
            }
            attempts++
            binding.txvAttempts.text = "Il reste ${(MAX_ATTEMPTS - attempts)} essais"

//            val x = 4
//            val validNumbers = listOf(0, 4, 6)
//            when (x) {
//                in 1..10 -> println("x is in the range")
//                in validNumbers -> println("x is valid")
//                !in 10..20 -> println("x is outside the range")
//                else -> println("none of the above")
//            }


        }

    }

    //Tout ce qui est dans le companion object est statique
    companion object {
        const val INTENT_EXTRA_PLAYER_NAME = "player_name"
        fun newIntent(context: Context, playerName: String): Intent {
            val intent = Intent(context, NumberActivity::class.java)
            intent.putExtra(INTENT_EXTRA_PLAYER_NAME, playerName)
            return intent
        }
    }
}