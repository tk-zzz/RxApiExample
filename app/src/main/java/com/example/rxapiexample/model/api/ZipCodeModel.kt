package com.example.rxapiexample.model.api

data class ZipCodeModel(
    var code: String?,
    var data: List<Data>?
)

data class Data (
    var prefcode: String?,
    var ja: ZipInfo?,
    var en: ZipInfo?
)

data class ZipInfo (
    var prefecture: String?,
    var address1: String?,
    var address2: String?,
    var address3: String?,
    var address4: String?
)