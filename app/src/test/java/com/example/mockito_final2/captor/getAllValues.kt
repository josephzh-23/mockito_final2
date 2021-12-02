package com.example.captor

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor

import org.mockito.Captor
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


//@ExtendWith(value = [MockitoExtension::class])
class MockitoCaptorTest3 {


    @Captor
    private val argumentCaptor: ArgumentCaptor<Person>? = null
    @Test
    fun capterTest() {
        val mockList: MutableList<Person> = mock(MutableList::class.java) as MutableList<Person>
        mockList.add(Person(10, "KK"))
        mockList.add(Person(20, "PK"))
        mockList.add(Person(30, "SK"))
        verify(mockList, times(3)).add(argumentCaptor!!.capture())
        val personList: List<Person> = argumentCaptor.getAllValues()
        assertEquals(10, personList[0].id)
        assertEquals("KK", personList[0].name)
//        assertEquals(20, personList[1].getId())
//        assertEquals("PK", personList[1].getName())
//        assertEquals(30, personList[2].getId())
//        assertEquals("SK", personList[2].getName())
    }
}