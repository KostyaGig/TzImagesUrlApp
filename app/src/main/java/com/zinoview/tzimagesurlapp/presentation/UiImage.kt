package com.zinoview.tzimagesurlapp.presentation



interface UiImage {

    fun toImageUrl() : String

    class Base(
        private val imageUrl: String
    ) : UiImage {

        override fun toImageUrl(): String
            = imageUrl
    }
}
