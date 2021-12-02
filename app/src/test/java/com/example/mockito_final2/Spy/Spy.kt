package com.example.mockito_final2.Spy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.spy
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner
import test_doubles.Mock_vs_spy.Employee
import test_doubles.Mock_vs_spy.EmployeeServiceImpl



@RunWith(MockitoJUnitRunner::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Add_behavior_to_spy {

    @BeforeAll
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }
    @Spy
    private val employeeService: EmployeeServiceImpl? = null

    // The actual function run here
    @Test
    fun addMockitoSpyBehaviorTest() {
        val spy: List<String> = spy(MutableList::class.java) as MutableList<String>
        doReturn(20).`when`(spy).size
        assertEquals(20, spy.size)
    }

}