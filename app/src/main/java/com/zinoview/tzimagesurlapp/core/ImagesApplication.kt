package com.zinoview.tzimagesurlapp.core

import android.app.Application
import com.zinoview.tzimagesurlapp.data.ExceptionMapper
import com.zinoview.tzimagesurlapp.data.ImagesRepository
import com.zinoview.tzimagesurlapp.data.cloud.CloudDataSource
import com.zinoview.tzimagesurlapp.data.cloud.ImagesServiceApi
import com.zinoview.tzimagesurlapp.domain.ImagesInteractor
import com.zinoview.tzimagesurlapp.presentation.ImagesViewModel
import com.zinoview.tzrecipesapp.presentation.state.UiImagesCommunication
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImagesApplication : Application() {

    private companion object {
        private const val BASE_URL = "http://translatorappserver.pythonanywhere.com/"
    }

    lateinit var imagesViewModel: ImagesViewModel

    override fun onCreate() {
        super.onCreate()

        val client =
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val service = retrofit.create(ImagesServiceApi::class.java)

        val repository = ImagesRepository.Base(
            CloudDataSource.Base(
                service
            ),
            ExceptionMapper.Base(
                ResourceProvider.Base(this)
            )
        )
        val interactor = ImagesInteractor.Base(
            repository
        )

        imagesViewModel = ImagesViewModel.Base(
            interactor,
            UiImagesCommunication.Base()
        )
    }
}