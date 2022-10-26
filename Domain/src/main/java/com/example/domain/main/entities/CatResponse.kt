package com.example.domain.main.entities

import com.google.gson.annotations.SerializedName

data class CatResponse(

    @SerializedName("fact") var fact: String? = null,
    @SerializedName("length") var length: Int? = null

)