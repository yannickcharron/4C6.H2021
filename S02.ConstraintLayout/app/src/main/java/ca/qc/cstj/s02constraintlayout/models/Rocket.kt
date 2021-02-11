package ca.qc.cstj.s02constraintlayout.models

import kotlin.random.Random

data class Rocket(
        var pilot: Pilot,
        var shield: Int = 5,
        var energy: Int = 5
) {
    fun start(orbits:Int, isTraining:Boolean) {
        pilot.drive(orbits, isTraining)
        energy -= Random.nextInt(1, orbits + 1)
        shield -= Random.nextInt(1, orbits + 1)

    }
}