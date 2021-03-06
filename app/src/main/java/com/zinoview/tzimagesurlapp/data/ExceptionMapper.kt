package com.zinoview.tzimagesurlapp.data

import com.zinoview.tzimagesurlapp.R
import com.zinoview.tzimagesurlapp.core.ResourceProvider
import retrofit2.HttpException
import java.net.UnknownHostException

interface ExceptionMapper {

    fun map(e: Exception): String

    class Base(
        private val resourceProvider: ResourceProvider
    ) : ExceptionMapper {

        override fun map(e: Exception): String {
            return when (e) {
                is UnknownHostException -> resourceProvider.string(R.string.no_connection_error_text)
                is HttpException -> resourceProvider.string(R.string.some_went_wrong_text)
                else -> throw IllegalArgumentException("ResourceProvider.Base not handle arg: ${e.javaClass}")
            }
        }
    }


    /**
     * Test [com.zinoview.tzimagesurlapp.data.ExceptionMapper.ExceptionMapperTest]
     */

    class Test : ExceptionMapper {
            override fun map(e: Exception): String {
                return when(e) {
                    is UnknownHostException -> "No connection"
                    is HttpException -> "Some went wrong"
                    else -> throw IllegalArgumentException("ResourceProvider.Base not handle arg: ${e.javaClass}")
                }
        }
    }
}
