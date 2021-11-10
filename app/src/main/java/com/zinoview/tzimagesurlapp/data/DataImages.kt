package com.zinoview.tzimagesurlapp.data

import com.zinoview.tzimagesurlapp.domain.DomainImages

sealed class DataImages {

    abstract fun toDomainImages() : DomainImages

    class Success(
        private val images: List<DataImage>
    ) : DataImages() {

        override fun toDomainImages(): DomainImages
            = DomainImages.Success(images.map { dataImage -> dataImage.toDomainImage() })
    }

    class Failure(
        private val message:String
    ) : DataImages() {

        override fun toDomainImages(): DomainImages
            = DomainImages.Failure(message)
    }
}