package com.zinoview.tzimagesurlapp.presentation.state

import android.view.View
import android.widget.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.squareup.picasso.Picasso


sealed class UiImageState {
    abstract fun handleState(
        images: List<ImageView>,
        errorTextView: TextView,
        swipeRefresh: SwipeRefreshLayout,
        imagesContainer: LinearLayout
    )


    object Progress : UiImageState() {

        override fun handleState(
            images: List<ImageView>,
            errorTextView: TextView,
            swipeRefresh: SwipeRefreshLayout,
            imagesContainer: LinearLayout
        )  {
            imagesContainer.visibility = View.GONE
            errorTextView.visibility = View.GONE
            swipeRefresh.isRefreshing = true
        }
    }

    class Base(
        private val imagesUrl: List<String>
    ) : UiImageState() {

        override fun handleState(
            images: List<ImageView>,
            errorTextView: TextView,
            swipeRefresh: SwipeRefreshLayout,
            imagesContainer: LinearLayout
        ) {
            swipeRefresh.isRefreshing = false
            swipeRefresh.isEnabled = false
            errorTextView.visibility = View.GONE

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
            swipeRefresh: SwipeRefreshLayout,
            imagesContainer: LinearLayout
        ) {
            swipeRefresh.isRefreshing = false
            swipeRefresh.isEnabled = true
            imagesContainer.visibility = View.GONE
            errorTextView.text = message
            errorTextView.visibility = View.VISIBLE
        }
    }
}