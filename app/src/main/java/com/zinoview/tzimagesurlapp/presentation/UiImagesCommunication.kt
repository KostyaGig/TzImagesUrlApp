package com.zinoview.tzrecipesapp.presentation.state

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.zinoview.tzimagesurlapp.presentation.UiImage
import com.zinoview.tzimagesurlapp.presentation.state.UiImageState
import com.zinoview.tzrecipesapp.presentation.core.Observe

interface UiImagesCommunication : Observe<UiImageState> {

    fun postValue(value: UiImageState)

    class Base : UiImagesCommunication {

        private val uiImageLiveData = MutableLiveData<UiImageState>()

        override fun postValue(value: UiImageState) {
            uiImageLiveData.value = value
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<UiImageState>) {
            uiImageLiveData.observe(owner, observer)
        }


    }
}