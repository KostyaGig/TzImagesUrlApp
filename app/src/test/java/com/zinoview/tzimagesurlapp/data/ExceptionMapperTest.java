package com.zinoview.tzimagesurlapp.data;

import static org.junit.Assert.*;

/**
 * Test for [com.zinoview.tzimagesurlapp.data.ExceptionMapper.Test]
 * */

class ExceptionMapperTest {

    @Test
    fun test_map_exception_to_string_message() {
        val exceptionMapper = ExceptionMapper.Test()
        var exception: Exception = UnknownHostException()
        var expected = "No connection"
        var actual = exceptionMapper.map(exception)

        assertEquals(expected, actual)

        exception = HttpException(Response.success(null))
        expected = "Some went wrong"
        actual = exceptionMapper.map(exception)

        assertEquals(expected, actual)
    }

}