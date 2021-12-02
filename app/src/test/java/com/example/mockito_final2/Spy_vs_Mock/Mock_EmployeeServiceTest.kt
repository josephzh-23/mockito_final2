package mockito.test_doubles.Spy_vs_Mock

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll

// This is using junit 5
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import test_doubles.Mock_vs_spy.Employee
import test_doubles.Mock_vs_spy.EmpoyeeService
import java.math.BigDecimal
import java.util.*


@RunWith(MockitoJUnitRunner::class)
@TestInstance(Lifecycle.PER_CLASS)
class EmpoyeeServiceTest1 {
        @Mock
    lateinit var empoyeeService: EmpoyeeService


//    private val empoyeeService: EmpoyeeService? = null
    @BeforeAll
    fun setUp() {
//        empoyeeService = Mockito.mock(EmpoyeeService::class.java)

    // We definitely need this for mocking
    MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testFetchEmployeeById() {
        val employee = employee

        Mockito.`when`(empoyeeService!!.fetchEmployeeById(10)).thenReturn(employee)
        Assertions.assertEquals("KK", empoyeeService!!.fetchEmployeeById(10)!!.employeeName)
        Assertions.assertEquals(50000.00, empoyeeService!!.fetchEmployeeById(10)!!.salary)

        Assertions.assertEquals("kk.cs2016@yahoo.com", empoyeeService!!.fetchEmployeeById(10)!!.email)


    }

    private val employee: Employee
        private get() {
            val employee = Employee()
            employee.employee_id = 10
            employee.bonus = BigDecimal(600)
            employee.doj = Date()
            employee.employeeName = "KK"
            employee.email = "kk.cs2016@yahoo.com"
            employee.salary = 50000.00
            return employee
        }
}