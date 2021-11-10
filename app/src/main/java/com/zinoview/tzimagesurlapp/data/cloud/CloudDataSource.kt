package com.zinoview.tzimagesurlapp.data.cloud


interface CloudDataSource {

    suspend fun images() : CloudImages

    class Base(
        private val serviceApi: ImagesServiceApi
    ) : CloudDataSource {

        override suspend fun images(): CloudImages {
            return serviceApi.images()
        }
    }
}