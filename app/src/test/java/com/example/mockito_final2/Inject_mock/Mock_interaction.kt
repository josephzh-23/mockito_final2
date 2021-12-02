package com.example.mockito_final2.Inject_mock

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import test_doubles.behavior_verification.Book
import test_doubles.behavior_verification.BookRepository
import test_doubles.behavior_verification.BookService
import java.time.LocalDate


@RunWith(MockitoJUnitRunner::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class mock_interaction {

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
        `when`(bookRepository?.findBookById("joseph")).thenReturn(book2)
        bookService?.updatePrice("joseph", 600)
        verify(bookRepository)?.save(book2)

        // Above won't work if do it with book 2
    }
}




