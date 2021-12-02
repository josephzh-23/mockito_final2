package mockito.test_doubles.Spy_vs_Mock


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.mockito.Mockito.spy
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner
import test_doubles.Mock_vs_spy.Employee
import test_doubles.Mock_vs_spy.EmployeeServiceImpl

/**
 * @author KK JavaTutorials
 * Use of @Spy Annotation
 */
@RunWith(MockitoJUnitRunner::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpyEmpoyeeServiceTest_1 {

    @BeforeAll
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }
    @Spy
    private val employeeService: EmployeeServiceImpl? = null

    // The actual function run here
    @Test
    fun testFetchEmployeeById() {
        System.out.println(employeeService.hashCode())
        val employee: Employee? = employeeService!!.fetchEmployeeById(2)
        println(employee)
    }

    @Test
    fun spyWithoutAnnotationTest() {
        val spyMyList = spy(ArrayList<String>())
        spyMyList.add("joseph")

        assertEquals(2, spyMyList.size)
    }
}