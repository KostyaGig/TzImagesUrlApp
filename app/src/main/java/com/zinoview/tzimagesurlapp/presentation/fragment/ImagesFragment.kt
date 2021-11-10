package com.zinoview.tzimagesurlapp.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.*
import com.zinoview.tzimagesurlapp.R
import com.zinoview.tzimagesurlapp.presentation.navigation.ExitActivity
import com.zinoview.tzimagesurlapp.presentation.core.BaseFragment

class ImagesFragment : BaseFragment(R.layout.images_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val firstImage = view.findViewById<ImageView>(R.id.image_1)
        val secondImage = view.findViewById<ImageView>(R.id.image_2)
        val thirdImage = view.findViewById<ImageView>(R.id.image_3)
        val fourthImage = view.findViewById<ImageView>(R.id.image_4)
        val fifthImage = view.findViewById<ImageView>(R.id.image_5)
        val sixthImage = view.findViewById<ImageView>(R.id.image_6)
        val seventhImage = view.findViewById<ImageView>(R.id.image_7)
        val eighthImage = view.findViewById<ImageView>(R.id.image_8)
        val ninthImage = view.findViewById<ImageView>(R.id.image_9)
        val tenthImage = view.findViewById<ImageView>(R.id.image_10)
        val eleventhImage = view.findViewById<ImageView>(R.id.image_11)
        val twelfthImage = view.findViewById<ImageView>(R.id.image_12)

        val errorTextView = view.findViewById<TextView>(R.id.error_tv)
        val progressBar = view.findViewById<ProgressBar>(R.id.pb)
        val imagesContainer = view.findViewById<LinearLayout>(R.id.images_container)
        val retryBtn = view.findViewById<Button>(R.id.retry_btn)

        val images = listOf(
            firstImage,
            secondImage,
            thirdImage,
            fourthImage,
            fifthImage,
            sixthImage,
            seventhImage,
            eighthImage,
            ninthImage,
            tenthImage,
            eleventhImage,
            twelfthImage
        )

        imagesViewModel.images()

        imagesViewModel.observe(this) { uiImageState ->
            uiImageState.handleState(images,errorTextView,progressBar,imagesContainer,retryBtn)
        }

        retryBtn.setOnClickListener {
            imagesViewModel.images()
        }
    }

    override fun navigateToBack()
        = (requireActivity() as ExitActivity).exit()
}