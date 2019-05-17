package com.example.history_project_rxjava.ui.place

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.history_project_rxjava.connect.Connecter
import com.example.history_project_rxjava.model.PlaceModel
import com.example.history_project_rxjava.util.SingleLiveEvent
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceViewModel(val app: Application) : AndroidViewModel(app) {

    val placeModel = MutableLiveData<ArrayList<PlaceModel>>()
    val placeName = MutableLiveData<String>()
    val gotoInfo=SingleLiveEvent<Any>()

    fun getPlace() {
        Connecter.api.getPlace().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ placeModel.value = it }, {})
    }

    fun itemTouch(index:Int){
        placeName.value=placeModel.value!![index].historicalSiteName
        gotoInfo.call()
    }
}