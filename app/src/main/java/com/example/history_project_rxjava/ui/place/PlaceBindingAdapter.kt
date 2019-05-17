package com.example.history_project_rxjava.ui.place

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.history_project_rxjava.adapter.PlaceAdapter
import com.example.history_project_rxjava.model.PlaceModel
import jp.wasabeef.glide.transformations.BlurTransformation
import com.bumptech.glide.request.RequestOptions.bitmapTransform


@BindingAdapter("placeData")
fun RecyclerView.setPlaceData(data: LiveData<ArrayList<PlaceModel>>) {
    val placeAdapter: PlaceAdapter = adapter as PlaceAdapter
    data.value?.let { placeAdapter.item = it }
}

@BindingAdapter("imageUrl", "error")
fun setImageUrl(view: ImageView, url: String, error: Drawable) {
    Glide.with(view.context).load(url)
        .apply(bitmapTransform(BlurTransformation(8, 1)))
        .apply(RequestOptions().override(200, 50)).into(view)
}
