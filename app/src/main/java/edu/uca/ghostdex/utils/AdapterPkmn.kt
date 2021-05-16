package edu.uca.ghostdex.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import edu.uca.ghostdex.R
import edu.uca.ghostdex.model.Pkmn
import edu.uca.ghostdex.ui.fragment.DetailFragment
import edu.uca.ghostdex.ui.fragment.MainFragment
import kotlinx.android.synthetic.main.item_pokemon.view.*


class AdapterPkmn () : RecyclerView.Adapter<AdapterPkmn.ViewHolder>(){
    lateinit var items: ArrayList<Pkmn>

    fun setPlaces(items: List<Pkmn>){
        this.items = items as ArrayList<Pkmn>
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val pkmnImage: ImageView = view.pkmn_image
        val pkdxnumber: TextView = view.pkdxnumber
        val pkmnname: TextView = view.pkmnname
        val descripton: TextView = view.description

        fun navigateToFragment(context: Context) {
            val frgManager: FragmentManager =
                (context as AppCompatActivity).supportFragmentManager
            val frg: DetailFragment = DetailFragment.newInstance(pkmnname.text.toString(), descripton.text.toString())
            frg.show(frgManager, "frg_Vista_Result")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_pokemon,
                    parent,
                    false
                )
            )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent: MainFragment =  MainFragment()
        val model= items[position]
        holder.pkdxnumber.text = "#"+model.pkdxnumber
        holder.pkmnname.text = model.pkmnname
        holder.descripton.text = model.description
        parent.context?.let { holder.navigateToFragment(it) }
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