package com.zinoview.tzimagesurlapp.data

import com.zinoview.tzimagesurlapp.domain.DomainImage


interface DataImage {

    fun toDomainImage() : DomainImage

    class Base(
        private val imageUrl: String
    ) : DataImage {

        override fun toDomainImage(): DomainImage
            = DomainImage.Base(imageUrl)
    }
}
