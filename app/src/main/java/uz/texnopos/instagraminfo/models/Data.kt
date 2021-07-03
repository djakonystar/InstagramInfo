package uz.texnopos.instagraminfo.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("full_name")
    val fullName: String,

    val username: String,

    @SerializedName("profile_picture")
    val profilePicture: Picture,

    @SerializedName("biography")
    val bio: String,

    val figures: Figures,

    @SerializedName("is_private")
    val isPrivate: Boolean,

    @SerializedName("is_business")
    val isBusiness: Boolean,

    val business: Business
)
