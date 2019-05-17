package com.example.history_project_rxjava.ui.place

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.history_project_rxjava.R
import com.example.history_project_rxjava.adapter.PlaceAdapter
import com.example.history_project_rxjava.databinding.ActivityPlaceBinding
import com.example.history_project_rxjava.ui.info.InfoActivity
import com.example.history_project_rxjava.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_place.*
import org.jetbrains.anko.startActivity

class PlaceActivity : DataBindingActivity<ActivityPlaceBinding>() {

    override val layoutId: Int get() = R.layout.activity_place

    private val viewModel: PlaceViewModel by lazy {
        ViewModelProviders.of(this).get(PlaceViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        place_get_rv.adapter=PlaceAdapter(viewModel)
        viewModel.getPlace()
        viewModel.gotoInfo.observe(this, Observer { startActivity<InfoActivity>("name" to viewModel.placeName.value) })
    }
}
