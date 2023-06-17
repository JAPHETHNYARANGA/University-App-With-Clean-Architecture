package com.example.testapp.domain.models

import com.google.gson.annotations.SerializedName

data class UniversityList(
    val country : String,
    @SerializedName("alpha_two_code")
    val alpha_two_code : String,
    val name: String,
    @SerializedName("state-province")
    val stateProvince: String,
    val domains:List<String>,
    @SerializedName("web-pages")
    val webPages:List<String>
)
