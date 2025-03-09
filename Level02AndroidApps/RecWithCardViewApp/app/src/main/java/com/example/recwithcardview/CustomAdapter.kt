package com.example.recwithcardview

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Activity, private val res: List<Animal>) :
    RecyclerView.Adapter<CustomAdapter.AnimalVH>() {
    class AnimalVH(v: View) : RecyclerView.ViewHolder(v) {
        val card: CardView = v.findViewById(R.id.card_container)
        val pic: ImageView = v.findViewById(R.id.card_image)
        val nameAnimal: TextView = v.findViewById(R.id.card_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalVH {
        val v = context.layoutInflater.inflate(R.layout.animal_list_item, parent, false)
        return AnimalVH(v)

    }

    override fun getItemCount() = res.size

    override fun onBindViewHolder(holder: AnimalVH, position: Int) {
        holder.pic.setImageResource(res[position].pic)
        holder.nameAnimal.setText(res[position].name)
        holder.card.setOnClickListener {
            Toast.makeText(context, res[position].name, Toast.LENGTH_SHORT).show()
        }
    }

}
//mainActivity: MainActivity, animals: MutableList<Animal>