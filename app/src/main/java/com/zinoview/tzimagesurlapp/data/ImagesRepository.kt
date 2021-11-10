package com.zinoview.tzimagesurlapp.data

import com.zinoview.tzimagesurlapp.data.cloud.CloudDataSource
import kotlinx.coroutines.delay

interface ImagesRepository {

    suspend fun images() : DataImages

    class Base(
        private val cloudDataSource: CloudDataSource,
        private val exceptionMapper: ExceptionMapper
    ) : ImagesRepository {

        override suspend fun images(): DataImages {
            delay(DELAY.toLong())
            return try {
                val cloudImages = cloudDataSource.images()
                DataImages.Success(cloudImages.toDataImages())
            } catch (e: Exception) {
                val errorMessage = exceptionMapper.map(e)
                DataImages.Failure(errorMessage)
            }
        }

        private companion object {
            private const val DELAY = 2500
        }
    }
}