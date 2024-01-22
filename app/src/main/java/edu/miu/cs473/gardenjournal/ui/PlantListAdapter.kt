package edu.miu.cs473.gardenjournal.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.miu.cs473.gardenjournal.R
import edu.miu.cs473.gardenjournal.db.Plant

class PlantListAdapter(private val plants: List<Plant>): RecyclerView.Adapter<PlantListAdapter.MyViewHolder>() {
    var onItemClick: ((Plant) -> Unit)? = null
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val plantName: TextView = itemView.findViewById(R.id.plantName)
        val plantType: TextView = itemView.findViewById(R.id.plantType)
        init{
            itemView.setOnClickListener {
                onItemClick?.invoke(plants[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.plant_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return plants.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.plantType.text = plants[position].type
        holder.plantName.text = plants[position].name
    }
}

