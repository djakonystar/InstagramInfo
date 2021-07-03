package uz.texnopos.instagraminfo

import uz.texnopos.instagraminfo.models.ModelNew

interface NetworkListener {
    fun onInstagramInfoResponse(model: ModelNew?)
    fun onInstagramInfoFailure(message: String?)
}