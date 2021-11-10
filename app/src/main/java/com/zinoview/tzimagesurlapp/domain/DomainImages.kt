package com.zinoview.tzimagesurlapp.domain

import com.zinoview.tzimagesurlapp.presentation.UiImages

sealed class DomainImages {

    abstract fun toUiImages() : UiImages

    class Success(
        private val images: List<DomainImage>
    ) : DomainImages() {

        override fun toUiImages(): UiImages {
            return UiImages.Success(images.map { dataImage -> dataImage.toUiImage() })
        }

    }

    class Failure(
        private val message:String
    ) : DomainImages() {

        override fun toUiImages(): UiImages {
            return UiImages.Failure(message)
        }
    }
}