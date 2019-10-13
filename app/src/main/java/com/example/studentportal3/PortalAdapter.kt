package com.example.studentportal3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.portal_button.view.*

class PortalAdapter(private val portals: List<Portal>) :
    RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.portal_button, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return portals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }

    // here in the ViewHolder you bind the portal values to the layout values.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(portal : Portal) {
            itemView.tvTitle.text = portal.name
            itemView.tvUrl.text = portal.url
        }
    }
}