package com.example.flagsexam

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FlagsAdaptor(private val context: Activity, private val flagsList: List<Countries>) :
    RecyclerView.Adapter<FlagsAdaptor.FlagsHolder>() {
    class FlagsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flagImg : ImageView = view.findViewById(R.id.img_flag)
        val flagTxt : TextView = view.findViewById(R.id.txt_flag)
        val flagCard : CardView = view.findViewById(R.id.flag_card_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagsHolder {
        val adaptorLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.flags_card_view,parent,false)
        return FlagsHolder(adaptorLayout)
    }

    override fun getItemCount() = flagsList.size

    override fun onBindViewHolder(holder: FlagsHolder, position: Int) {
        holder.flagImg.setImageResource(flagsList[position].flagImage)
        holder.flagTxt.setText(flagsList[position].flagName)
        holder.flagCard.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            val geo = "geo:${flagsList[position].flagGeoLad}," +
            "${flagsList[position].flagGeoLong}?=" +
            "${context.getText(flagsList[position].flagName)}"
            intent.data = Uri.parse(geo)
            context.startActivity(intent)
            //${context.getText(flagsList[position].flagGeoLad)}
            //${context.getText(flagsList[position].flagGeoLong)}
        }
    }

}