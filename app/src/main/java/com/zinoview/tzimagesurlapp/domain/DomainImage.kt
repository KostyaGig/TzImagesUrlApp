package com.zinoview.tzimagesurlapp.domain

import com.zinoview.tzimagesurlapp.presentation.UiImage


interface DomainImage {

    fun toUiImage() : UiImage

    class Base(
        private val imageUrl: String
    ) : DomainImage {

        override fun toUiImage(): UiImage
            = UiImage.Base(imageUrl)
    }
}
