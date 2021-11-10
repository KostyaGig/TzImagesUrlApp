package com.zinoview.tzimagesurlapp.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.zinoview.tzimagesurlapp.R
import com.zinoview.tzimagesurlapp.core.ResourceProvider
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
        val imagesContainer = view.findViewById<LinearLayout>(R.id.images_container)

        val swipeRefresh = view.findViewById<SwipeRefreshLayout>(R.id.swipe_refresh)

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
            uiImageState.handleState(images,errorTextView,swipeRefresh,imagesContainer)
        }


        swipeRefresh.setOnRefreshListener {
            imagesViewModel.images()
        }

        val resourceProvider = ResourceProvider.Base(requireContext())
        firstImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_1))
        }

        secondImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_2))
        }

        thirdImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_3))
        }

        fourthImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_4))
        }

        fifthImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_5))
        }

        sixthImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_6))
        }

        seventhImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_7))
        }

        eighthImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_8))
        }

        ninthImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_9))
        }

        tenthImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_10))
        }

        eleventhImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_11))
        }

        twelfthImage.setOnClickListener {
            navigateTo(resourceProvider.string(R.string.image_12))
        }
    }

    override fun navigateToBack()
        = (requireActivity() as ExitActivity).exit()

    private fun navigateTo(imageUrl: String) {
        val detailImageFragment = DetailImageFragment()
        detailImageFragment.arguments = Bundle().apply {
            putString(IMAGE_URL_KEY,imageUrl)
        }
        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,detailImageFragment)
            .commit()
    }
}

