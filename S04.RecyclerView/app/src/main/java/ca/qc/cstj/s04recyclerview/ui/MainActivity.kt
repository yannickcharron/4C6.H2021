package ca.qc.cstj.s04recyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.s04recyclerview.databinding.ActivityMainBinding
import ca.qc.cstj.s04recyclerview.repositories.PlanetRepository
import ca.qc.cstj.s04recyclerview.ui.adapters.PlanetRecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var planetRecyclerViewAdapter: PlanetRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        planetRecyclerViewAdapter = PlanetRecyclerViewAdapter(listOf())
        binding.rcvPlanets.layoutManager = LinearLayoutManager(this) //Liste ou Grille
        binding.rcvPlanets.adapter = planetRecyclerViewAdapter

        val planetRepository = PlanetRepository()
        //observe == await en javascript le code du observe exécuté quand l'asynchrone est fini
        planetRepository.retrieveAll().observe(this, { it
            planetRecyclerViewAdapter.planets = it
            planetRecyclerViewAdapter.notifyDataSetChanged()
        })

    }
}