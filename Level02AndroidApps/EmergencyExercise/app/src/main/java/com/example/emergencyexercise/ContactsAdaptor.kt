package com.example.emergencyexercise

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.emergencyexercise.model.Contacts

class ContactsAdaptor(val context: Activity, val resListContacts: List<Contacts>) :
    RecyclerView.Adapter<ContactsAdaptor.ContactsHolder>() {
    class ContactsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.txt_name_contact)
        val number: TextView = view.findViewById(R.id.txt_number_contact)
        val cardView: CardView = view.findViewById(R.id.card_view_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsHolder {
        val adaptorLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_view_contacts, parent, false)
        return ContactsHolder(adaptorLayout)
    }

    override fun getItemCount() = resListContacts.size

    override fun onBindViewHolder(holder: ContactsHolder, position: Int) {
        holder.name.setText(resListContacts[position].name)
        val num = holder.number.setText(resListContacts[position].number)

        holder.cardView.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, "tel:${num}".toUri())
            context.startActivity(intent)
        }
    }
}