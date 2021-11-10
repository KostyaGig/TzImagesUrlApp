package com.zinoview.tzimagesurlapp.presentation

import com.zinoview.tzimagesurlapp.presentation.state.UiImageState

sealed class UiImages {

    abstract fun toUiImageState() : UiImageState

    class Success(
        private val images: List<UiImage>
    ) : UiImages() {

        override fun toUiImageState(): UiImageState
            = UiImageState.Base(images.map { uiImage -> uiImage.toImageUrl()  })
    }

    class Failure(
        private val message:String
    ) : UiImages() {

        override fun toUiImageState(): UiImageState
            = UiImageState.Failure(message)

    }
}