package com.herbeth.retrofit

import com.google.gson.annotations.SerializedName

/*
Classe que representa o json Post
 */
class PostModel {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("userId")
    var userId: Int = 0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("body")
    var body: String = ""

}