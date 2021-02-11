package ca.qc.cstj.s02constraintlayout

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import androidx.lifecycle.MutableLiveData
import ca.qc.cstj.s02constraintlayout.databinding.ActivityMainBinding
import ca.qc.cstj.s02constraintlayout.helpers.notifyObserver
import ca.qc.cstj.s02constraintlayout.models.Pilot
import ca.qc.cstj.s02constraintlayout.models.Rocket

class MainActivity : AppCompatActivity() {

    //Permet d'accéder aux composants de l'interface graphique
    private lateinit var binding: ActivityMainBinding
    private val _rocket = Rocket(Pilot("Yiznik"))

    private val rocket = MutableLiveData(_rocket)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Transforme et charge le XML en mémoire
        setContentView(binding.root)

        //Quand la rocket est modifiée
        rocket.observe(this, {
            binding.txvPilot.text = it.pilot.name
            binding.txvLevel.text = it.pilot.level.toString()
            binding.txvLife.text = it.pilot.life.toString()
            binding.txvShield.text = it.shield.toString()
            binding.txvEnergy.text = it.energy.toString()
            binding.txvCube.text = it.pilot.cube.toString()
        })



        binding.btnStart.setOnClickListener {

            val layoutParams = binding.imvRocketExercice.layoutParams as ConstraintLayout.LayoutParams
            val startAngle = layoutParams.circleAngle
            val endAngle = startAngle - 360

            val animation = ValueAnimator.ofFloat(startAngle, endAngle)
            animation.repeatCount = binding.sldRevolution.value.toInt() - 1
            animation.duration = 5000
            animation.interpolator = LinearInterpolator()
            animation.addUpdateListener { valueAnimator ->

                val animatedValue = valueAnimator.animatedValue as Float
                val layoutParamsAnim = binding.imvRocketExercice.layoutParams as ConstraintLayout.LayoutParams
                layoutParamsAnim.circleAngle = animatedValue
                binding.imvRocketExercice.layoutParams = layoutParamsAnim
                binding.imvRocketExercice.rotation = (animatedValue % 360 - 90)

            }

            animation.doOnEnd {
                _rocket.start(binding.sldRevolution.value.toInt(), binding.swtTraining.isChecked)
                rocket.notifyObserver()
            }
            animation.start()



        }
    }
}