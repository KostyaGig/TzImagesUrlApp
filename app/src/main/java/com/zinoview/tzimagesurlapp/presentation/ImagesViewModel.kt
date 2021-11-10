package com.zinoview.tzimagesurlapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zinoview.tzimagesurlapp.domain.ImagesInteractor
import com.zinoview.tzimagesurlapp.presentation.state.UiImageState
import com.zinoview.tzrecipesapp.presentation.core.Observe
import com.zinoview.tzrecipesapp.presentation.state.UiImagesCommunication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface ImagesViewModel : Observe<UiImageState> {

    fun images()

    class Base(
        private val interactor: ImagesInteractor,
        private val imagesCommunication: UiImagesCommunication,
        private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
    ) : ImagesViewModel, ViewModel() {

        override fun images() {
            imagesCommunication.postValue(UiImageState.Progress)
            viewModelScope.launch(defaultDispatcher) {
                val domainImages = interactor.images()
                val uiImages = domainImages.toUiImages()
                val uiImageState = uiImages.toUiImageState()

                withContext(Dispatchers.Main) {
                    imagesCommunication.postValue(uiImageState)
                }
            }
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<UiImageState>)
            = imagesCommunication.observe(owner,observer)

    }
}