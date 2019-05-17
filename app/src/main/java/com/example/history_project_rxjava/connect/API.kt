package com.example.history_project_rxjava.connect

import com.example.history_project_rxjava.model.PlaceModel
import io.reactivex.Single
import retrofit2.http.GET

interface API {
    @GET("main/bla")
    fun getPlace(): Single<ArrayList<PlaceModel>>
}