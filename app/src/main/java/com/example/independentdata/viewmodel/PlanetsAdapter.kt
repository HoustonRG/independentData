package com.example.independentdata.viewmodel

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.independentdata.R
import com.example.independentdata.databinding.PlanetListBinding
import com.example.independentdata.model.PlanetData
import com.example.independentdata.view.NewActivity

class PlanetsAdapter (

    var c: Context, var planetList: ArrayList<PlanetData>

): RecyclerView.Adapter<PlanetsAdapter.PlanetViewHolder>() {

    inner class PlanetViewHolder(var v: PlanetListBinding): RecyclerView.ViewHolder(v.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<PlanetListBinding>(
            inflater, R.layout.planet_list, parent, false
        )
        return PlanetViewHolder(v)
    }

    override fun getItemCount(): Int {
        return planetList.size
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val newList = planetList[position]
     holder.v.isPlanets = planetList[position]
        holder.v.root.setOnClickListener {
            val planetImage = newList.planetImage
            val planetName = newList.planetName
           val  planetType = newList.planetType
            val planetDescription = newList.planetDescription

            val nIntent = Intent(c, NewActivity::class.java)
            nIntent.putExtra("planetImage", planetImage)
            nIntent.putExtra("planetName", planetName)
            nIntent.putExtra("planetType", planetType)
            nIntent.putExtra("planetDescription", planetDescription)
            c.startActivity(nIntent)
        }
    }
}