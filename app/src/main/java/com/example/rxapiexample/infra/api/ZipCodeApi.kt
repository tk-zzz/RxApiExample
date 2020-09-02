package com.example.rxapiexample.infra.api

import com.example.rxapiexample.model.api.ZipCodeModel
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface ZipCodeApi {
    @GET("api/v1/{zip1}/{zip2}.json")
    fun getZipCode(@Path("zip1") zip1: String, @Path("zip2") zip2: String) : Observable<ZipCodeModel>
}