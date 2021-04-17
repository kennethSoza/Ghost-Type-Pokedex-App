package edu.uca.ghostdex.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.uca.ghostdex.model.Pkmn
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_pokemon.view.*
import edu.uca.ghostdex.R

class AdapterPkmn () : RecyclerView.Adapter<AdapterPkmn.ViewHolder>(){
    lateinit var items: ArrayList<Pkmn>

    fun setPlaces(items: List<Pkmn>){
        this.items = items as ArrayList<Pkmn>
        notifyDataSetChanged()
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val pkmnImage: ImageView = view.pkmn_image
        val pkdxnumber: TextView = view.pkdxnumber
        val pkmnname: TextView = view.pkmnname
        val descripton: TextView = view.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.pkdxnumber.text = model.pkdxnumber
        holder.pkmnname.text = model.pkmnname
        holder.descripton.text = model.description
        Picasso.get()
            .load(model.url)
            .into(holder.pkmnImage)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }
    }



}