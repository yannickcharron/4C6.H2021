package ca.qc.cstj.s04recyclerview.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.s04recyclerview.R
import ca.qc.cstj.s04recyclerview.databinding.ItemPlanetBinding
import ca.qc.cstj.s04recyclerview.helpers.loadFromResource
import ca.qc.cstj.s04recyclerview.models.Planet
import java.util.*

class PlanetRecyclerViewAdapter(var planets:List<Planet>) :
    RecyclerView.Adapter<PlanetRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //TODO: Prend le XML de l'item et le transformer en ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false)
        //TODO: Retourner le ViewHolder
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val planet = planets[position]
        holder.bind(planet)
    }

    override fun getItemCount(): Int = planets.size


    //Classe qui permet la gestion de l'interface graphique d'un item
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val binding = ItemPlanetBinding.bind(view)

        fun bind(planet:Planet) {
            binding.txvNamePlanet.text = planet.name
            binding.txvTemperaturePlanet.text = String.format("%.3f", planet.temperature)
            binding.imvImagePlanet.loadFromResource(binding.root.context, planet.image)

        }

    }

}