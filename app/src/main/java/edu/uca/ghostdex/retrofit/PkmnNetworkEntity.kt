package edu.uca.ghostdex.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PkmnNetworkEntity (
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("pkdxnumber")
    @Expose
    var pkdxnumber: String,

    @SerializedName("pkmnname")
    @Expose
    var pkmnname: String,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("url")
    @Expose
    var url: String,
)