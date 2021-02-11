package ca.qc.cstj.s02constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.qc.cstj.s02constraintlayout.databinding.ActivityMainBinding
import ca.qc.cstj.s02constraintlayout.models.Pilot
import ca.qc.cstj.s02constraintlayout.models.Rocket

class MainActivity : AppCompatActivity() {

    //Permet d'accéder aux composants de l'interface graphique
    private lateinit var binding: ActivityMainBinding
    private val rocket = Rocket(Pilot("Yiznik"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Transforme et charge le XML en mémoire
        setContentView(binding.root)

        binding.txvPilot.text = rocket.pilot.name
        binding.txvLevel.text = rocket.pilot.level.toString()
        binding.txvLife.text = rocket.pilot.life.toString()
        binding.txvShield.text = rocket.shield.toString()
        binding.txvEnergy.text = rocket.energy.toString()
        binding.txvCube.text = rocket.pilot.cube.toString()

        binding.btnStart.setOnClickListener {
            rocket.start(binding.sldRevolution.value.toInt(), binding.swtTraining.isChecked)

            //Ceci sera supprimé dans 20 minutes
            binding.txvPilot.text = rocket.pilot.name
            binding.txvLevel.text = rocket.pilot.level.toString()
            binding.txvLife.text = rocket.pilot.life.toString()
            binding.txvShield.text = rocket.shield.toString()
            binding.txvEnergy.text = rocket.energy.toString()
            binding.txvCube.text = rocket.pilot.cube.toString()

        }
    }
}