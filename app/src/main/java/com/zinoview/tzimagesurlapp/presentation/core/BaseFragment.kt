package com.zinoview.tzimagesurlapp.presentation.core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.zinoview.tzimagesurlapp.core.ImagesApplication

abstract class BaseFragment(@LayoutRes layoutResId: Int) : Fragment(layoutResId) {

    protected val imagesViewModel by lazy {
        ((requireActivity() as MainActivity).application as ImagesApplication).imagesViewModel
    }

    abstract fun navigateToBack()

    protected companion object {
        const val IMAGE_URL_KEY = "image_url"
    }
}