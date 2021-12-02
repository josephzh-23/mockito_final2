package com.example.mockito_final2.behavior_verification

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import test_doubles.behavior_verification.Book
import test_doubles.behavior_verification.BookRepository
import test_doubles.behavior_verification.BookService
import java.time.LocalDate
import org.mockito.Mockito.*
import org.mockito.Mockito.verifyNoInteractions

import com.example.behavior_verification.MyUtils





@RunWith(MockitoJUnitRunner::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class behavior_verify {

    //	@Mock
    //	private BookRepository bookRepository;
    @Mock
    private val bookRepository: BookRepository? = null

    @InjectMocks
    // Book repo is injected into book service via constructor injection
    private val bookService: BookService? = null
    @BeforeAll
    fun setUp() {
//        empoyeeService = Mockito.mock(EmpoyeeService::class.java)

        // We definitely need this for mocking
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun testUpdatePrice() {
        val book1 = Book("1234", "Mockito In Action", 250, LocalDate.now())

        val book2 = Book("1234", "Mockito In Action", 250, LocalDate.now())

//        bookService?.updatePrice(null, 600)
        /*
        We are forcefully making finbookid return book2
         */
        Mockito.`when`(bookRepository?.findBookById("joseph")).thenReturn(book2)
        bookService?.updatePrice("joseph", 600)
        Mockito.verify(bookRepository)?.save(book2)

        // Part 2
        verify(bookRepository, never())?.save(book1)

        // Above won't work if do it with book 2
    }


    @Test
    fun verify2Test() {
        val mock: MyUtils = mock(MyUtils::class.java)
        mock.add(10, 30)
        mock.add(10, 30)
        mock.add(10, 30)
        mock.add(10, 30)
        mock.add(10, 30)
        verify(mock, times(5)).add(10, 30)
        verify(mock, atLeast(2)).add(10, 30)
        verify(mock, atLeast(5)).add(10, 30)
        verify(mock, atLeastOnce()).add(10, 30)
    }

    @Test
    fun verify3Test() {
        val mock1 = mock(MyUtils::class.java)
        val mock2 = mock(MyUtils::class.java)
        //mock1.add(10, 30);
        verifyNoInteractions(mock1, mock2)
    }
}

