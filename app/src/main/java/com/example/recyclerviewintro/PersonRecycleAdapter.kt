package com.example.recyclerviewintro

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonRecycleAdapter(private val context : Context, private val persons: List<Person>) : RecyclerView.Adapter<PersonRecycleAdapter.ViewHolder>() {
    //inflator behövs för att skapa en view utifrån en layout (xml)
    private val layoutInflater = LayoutInflater.from(context)

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       //använder vår inflator för att skapa en view
       val itemView = layoutInflater.inflate(R.layout.list_item, parent, false )
       // skapar vi en viewHolder av vår egna klass ViewHolder (skriven längre ner här)
       return ViewHolder(itemView)
    }

    // hur många views ska recyclerviewn innehålla? så många som finns i persons!
    override fun getItemCount() = persons.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //när en item_view ska populeras tar vi rätt person från vår data
        val person = persons[position]
        // sätter in den personens uppgifter i vår view
        holder.textViewName.text = person.name
        holder.textViewAge.text = person.age.toString()
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        // när en viewholder skapas så letar vi reda på våra två textview:s som finns i vår item_view
        val textViewName = itemView.findViewById<TextView>(R.id.textName)
        val textViewAge = itemView.findViewById<TextView>(R.id.textAge)
    }

}