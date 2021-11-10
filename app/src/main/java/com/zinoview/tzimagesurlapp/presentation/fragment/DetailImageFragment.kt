package com.zinoview.tzimagesurlapp.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.zinoview.tzimagesurlapp.R
import com.zinoview.tzimagesurlapp.presentation.core.BaseFragment
import com.zinoview.tzimagesurlapp.presentation.core.MainActivity

class DetailImageFragment : BaseFragment(R.layout.detail_image_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val detailImage = view.findViewById<ImageView>(R.id.detail_image)

        arguments?.let {  bundle ->
            val imageUrlDetailFragment = bundle.getString(IMAGE_URL_KEY)
            Picasso.get().load(imageUrlDetailFragment).into(detailImage)
        }
    }

    override fun navigateToBack() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,ImagesFragment())
            .commit()
    }
}