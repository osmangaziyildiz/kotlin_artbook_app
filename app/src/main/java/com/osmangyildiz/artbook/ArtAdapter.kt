package com.osmangyildiz.artbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osmangyildiz.artbook.databinding.RecyclerRowBinding

class ArtAdapter(val artList: ArrayList<Art>) : RecyclerView.Adapter<ArtAdapter.ArtHolder>() {

    class ArtHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtHolder(binding)
    }

    override fun getItemCount(): Int {
        return artList.size
    }

    override fun onBindViewHolder(holder: ArtHolder, position: Int) {
        holder.binding.recyclerTextView.text = artList[position].name
        holder.itemView.setOnClickListener {
            val artAdapterIntent = Intent(holder.itemView.context, DetailsActivity::class.java)
            artAdapterIntent.putExtra("info", "old")
            artAdapterIntent.putExtra("id", artList[position].id)
            holder.itemView.context.startActivity(artAdapterIntent)
        }
    }

}