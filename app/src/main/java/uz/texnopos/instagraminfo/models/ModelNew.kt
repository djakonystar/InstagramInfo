package uz.texnopos.instagraminfo.models

import com.google.gson.annotations.SerializedName

data class ModelNew(
    @SerializedName("biography")
    val bio: String,

    @SerializedName("edge_followed_by")
    val followers: Followers,

    @SerializedName("edge_follow")
    val followings: Followings,

    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("is_business_account")
    val isBusiness: Boolean,

    @SerializedName("is_private")
    val isPrivate: Boolean,

    @SerializedName("profile_pic_url_hd")
    val picture: String,

    val username: String,

    @SerializedName("edge_owner_to_timeline_media")
    val posts: Posts
)
