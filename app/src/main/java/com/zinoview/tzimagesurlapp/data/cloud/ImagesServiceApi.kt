package com.zinoview.tzimagesurlapp.data.cloud

import retrofit2.http.GET

/**
 * Base url - http://dev-tasks.alef.im/task-m-001
 * */

interface ImagesServiceApi {

    @GET("images")
    suspend fun images() : CloudImages
}