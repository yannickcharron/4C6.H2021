package ca.qc.cstj.s04recyclerview.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ca.qc.cstj.s04recyclerview.models.Planet
import kotlin.random.Random

class PlanetRepository {

    fun retrieveAll() : LiveData<List<Planet>> {

        val amountToGenerate = Random.nextInt(0, 21)
        val planets = mutableListOf<Planet>()

        for (i in 0..amountToGenerate) {
            val planetImage = Random.nextInt(1, 7)
            val temperature = Random.nextDouble(0.0, 60.0)
            val planet = Planet("Planet $i", "planet$planetImage", temperature)

            planets.add(planet)
        }

        //val results = MutableLiveData<List<Planet>>()
        //results.postValue(planets)
        //return results
        return MutableLiveData<List<Planet>>().apply { postValue(planets) }

    }

}