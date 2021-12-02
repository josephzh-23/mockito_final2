package com.example.mockito_final2.exception_handling

import com.example.mockito_final2.Inject_Mock.WordDictionary
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers

import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.NullPointerException

@RunWith(MockitoJUnitRunner::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WordDictionaryTest {


    @BeforeAll
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }
    /**
     * Test for non-void Return Type method with Exception
     */
    @Test
    fun nonVoidMethodThrowingExceptionMockitoTest() {
        try {
            val wordDictionary: WordDictionary = mock(WordDictionary::class.java)
            `when`(wordDictionary.getMeaning(anyString()))
                .thenThrow(NullPointerException::class.java)
            wordDictionary.getMeaning("awesome")
        } catch (e: Exception) {
            println("Exception occured!!")
            assertTrue(e is NullPointerException)
        }
    }

    /**
     * this passed for sure 
     * Test for void Return Type method with Exception
     */
    @Test
    fun voidMethodThrowingExceptionMockitoTest() {
        val wordDictionary: WordDictionary = mock(WordDictionary::class.java)

        // Basically wehn you add something to this , you want this to throw error
        doThrow(IllegalStateException("Error occurred!!"))
            .`when`(wordDictionary)
            .add(anyString(), anyString())
        assertThrows(IllegalStateException::class.java) {
            wordDictionary.add(
                "awesome",
                "Very Good"
            )
        }
    }

    /**
     * Configuring Spy to throw an exception the same way we've done with the mock
     */
    @Test
    fun nonVoidMethodThrowingExceptionWithSpyMockitoTest() {
        val emptyWord = ""
        try {
            val wordDictionary = WordDictionary()
            val spyWordDictionary: WordDictionary = spy(wordDictionary)
            `when`(spyWordDictionary.getMeaning(emptyWord))
                .thenThrow(IllegalArgumentException("Input is not valid!!"))
            spyWordDictionary.getMeaning(emptyWord)
        } catch (e: Exception) {
            assertTrue(e is IllegalArgumentException)
            assertEquals("Input is not valid!!", e.message)
        }
    }
}