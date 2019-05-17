package com.example.history_project_rxjava.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.history_project_rxjava.databinding.ItemPlaceBinding
import com.example.history_project_rxjava.model.PlaceModel
import com.example.history_project_rxjava.ui.place.PlaceViewModel

class PlaceAdapter(val viewModel: PlaceViewModel) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    var item = arrayListOf<PlaceModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val binding = ItemPlaceBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind()
    }


    override fun getItemCount(): Int = item.size

    inner class ViewHolder(val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.placeModel = item[adapterPosition]
            binding.index = adapterPosition
            binding.vm = viewModel
        }
    }

}