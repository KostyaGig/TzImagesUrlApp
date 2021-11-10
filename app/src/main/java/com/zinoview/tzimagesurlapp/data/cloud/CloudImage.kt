package com.zinoview.tzimagesurlapp.data.cloud

import com.zinoview.tzimagesurlapp.data.DataImage


class CloudImages(
    private val images: List<CloudImage>
) {

    fun toDataImages() : List<DataImage>
        = images.map { dataImage -> dataImage.toDataImage() }

}

class CloudImage(
    private val imageUrl: String
) {

    fun toDataImage() : DataImage
        = DataImage.Base(imageUrl)
}
