package com.example.captor

import android.content.ContentValues.TAG
import com.example.mockito_final2.Log
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith

import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


// Only sample but when you run will fail
@RunWith(MockitoJUnitRunner::class)
class MockitoCaptorTest2 {


    @Captor
    private val argumentCaptor: ArgumentCaptor<String>? = null
    @Test
    fun capterTest() {
        val mockList: MutableList<String> = Mockito.mock(
            MutableList::class.java
        ) as MutableList<String>
        mockList.add("KK")
        Log.i(TAG, "capterTest: $mockList and $argumentCaptor")
        Mockito.verify(mockList).add(argumentCaptor!!.capture())
        assertEquals("KK", argumentCaptor.value)
    }
}