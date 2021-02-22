package ca.qc.cstj.s04recyclerview.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import ca.qc.cstj.s04recyclerview.R
import ca.qc.cstj.s04recyclerview.databinding.ItemPlanetBinding
import ca.qc.cstj.s04recyclerview.helpers.Services
import ca.qc.cstj.s04recyclerview.helpers.loadFromResource
import ca.qc.cstj.s04recyclerview.models.Planet
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class PlanetRecyclerViewAdapter(var planets:List<Planet>, private val onPlanetListener: OnPlanetListener) :
    RecyclerView.Adapter<PlanetRecyclerViewAdapter.ViewHolder>() {

    private lateinit var circularProgressDrawable: CircularProgressDrawable

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //TODO: Prend le XML de l'item et le transformer en ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false)

        circularProgressDrawable = CircularProgressDrawable(view.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()


        //TODO: Retourner le ViewHolder
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val planet = planets[position]
        holder.bind(planet)
        holder.itemView.setOnClickListener {
            //Toast.makeText(holder.itemView.context, planet.name, Toast.LENGTH_LONG).show()
            onPlanetListener.onClick(planet)
        }
    }

    override fun getItemCount(): Int = planets.size


    //Classe qui permet la gestion de l'interface graphique d'un item
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val binding = ItemPlanetBinding.bind(view)

        fun bind(planet:Planet) {
            binding.txvNamePlanet.text = planet.name
            binding.txvTemperaturePlanet.text = String.format("%.3f", planet.temperature)
            //binding.imvImagePlanet.loadFromResource(binding.root.context, planet.image)

            val requestOptions = RequestOptions()
                    .placeholder(circularProgressDrawable)
                    .error(R.drawable.ic_launcher_foreground)

            Glide.with(binding.root.context)
                .applyDefaultRequestOptions(requestOptions)
                .load("${Services.IMAGE_URL}${planet.image}")
                .into(binding.imvImagePlanet)

        }

    }

    interface OnPlanetListener {
        fun onClick(planet: Planet)
    }

}