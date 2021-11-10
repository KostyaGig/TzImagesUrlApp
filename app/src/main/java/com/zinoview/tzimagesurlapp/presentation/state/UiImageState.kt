package com.zinoview.tzimagesurlapp.presentation.state

import android.view.View
import android.widget.*
import com.squareup.picasso.Picasso


sealed class UiImageState {
    abstract fun handleState(
        images: List<ImageView>,
        errorTextView: TextView,
        progressBar: ProgressBar,
        imagesContainer: LinearLayout,
        retryBtn: Button
    )


    object Progress : UiImageState() {

        override fun handleState(
            images: List<ImageView>,
            errorTextView: TextView,
            progressBar: ProgressBar,
            imagesContainer: LinearLayout,
            retryBtn: Button
        )  {
            imagesContainer.visibility = View.GONE
            errorTextView.visibility = View.GONE
            retryBtn.visibility = View.GONE
            progressBar.visibility = View.VISIBLE

        }
    }

    class Base(
        private val imagesUrl: List<String>
    ) : UiImageState() {

        override fun handleState(
            images: List<ImageView>,
            errorTextView: TextView,
            progressBar: ProgressBar,
            imagesContainer: LinearLayout,
            retryBtn: Button
        ) {
            progressBar.visibility = View.GONE
            errorTextView.visibility = View.GONE
            retryBtn.visibility = View.GONE

            for (i in images.indices) {
                Picasso.get().load(imagesUrl[i]).into(images[i])
            }

            imagesContainer.visibility = View.VISIBLE
        }
    }

    class Failure(
        private val message: String
    ) : UiImageState() {

        override fun handleState(
            images: List<ImageView>,
            errorTextView: TextView,
            progressBar: ProgressBar,
            imagesContainer: LinearLayout,
            retryBtn: Button
        ) {
            progressBar.visibility = View.GONE
            imagesContainer.visibility = View.GONE
            retryBtn.visibility = View.VISIBLE
            errorTextView.text = message
            errorTextView.visibility = View.VISIBLE
        }
    }
}