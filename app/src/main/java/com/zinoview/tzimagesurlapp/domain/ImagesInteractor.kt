package com.zinoview.tzimagesurlapp.domain

import com.zinoview.tzimagesurlapp.data.ImagesRepository

interface ImagesInteractor {

    suspend fun images() : DomainImages

    class Base(
        private val repository: ImagesRepository
    ) : ImagesInteractor {

        override suspend fun images(): DomainImages {
            val dataImages = repository.images()
            return dataImages.toDomainImages()
        }
    }
}