package ca.qc.cstj.s02constraintlayout.models

import kotlin.random.Random

data class Pilot(
        var name: String,
        var life: Int = 10,
        var cube: Int = 0
) {
    private var experience = 0

    val level: Int
        get() = experience / 10

    fun drive(orbits: Int, isTraining: Boolean) {
        if (!isTraining) {
            experience += orbits * Random.nextInt(1, 6)
            life -= Random.nextInt(0, 2)
            cube += orbits * Random.nextInt(0,3)
        }
    }
}