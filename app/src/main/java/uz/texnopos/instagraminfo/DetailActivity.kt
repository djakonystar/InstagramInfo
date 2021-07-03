package uz.texnopos.instagraminfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import uz.texnopos.instagraminfo.databinding.ActivityDetailBinding
import uz.texnopos.instagraminfo.models.Model
import uz.texnopos.instagraminfo.models.ModelNew
import uz.texnopos.instagraminfo.retrofit.ApiClient

class DetailActivity : AppCompatActivity(), NetworkListener {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        networkHelper = NetworkHelper(ApiClient.getClient())
        val username = intent.getStringExtra("username")
        setData(username ?: "texnopos")
    }

    private fun setData(username: String) {
        networkHelper.getInfo(this, username)
    }

    override fun onInstagramInfoResponse(model: ModelNew?) {
        binding.apply {
            Glide.with(picture).load(model?.picture).into(picture)
            username.text = model?.username
            posts.text = model?.posts?.count.toString()
            followers.text = model?.followers?.count.toString()
            followings.text = model?.followings?.count.toString()
            fullName.text = model?.fullName
            bio.text = model?.bio
            type.text = if (model?.isPrivate == true) "Private account" else "Public account"
            businessTitle.text = if (model?.isBusiness == true) "Business account" else "Not business account"
        }
    }

    override fun onInstagramInfoFailure(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}