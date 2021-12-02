package test_doubles.Mock_vs_spy

import java.math.BigDecimal
import java.util.*


class Employee {
    var employee_id = 0
    var employeeName: String? = null
    var email: String? = null
    var salary: Double? = null
    var doj: Date? = null
    var bonus: BigDecimal? = null

    override fun toString(): String {
        return ("Employee [employee_id=" + employee_id + ", employeeName=" + employeeName + ", email=" + email
                + ", salary=" + salary + ", doj=" + doj + ", bonus=" + bonus + "]")
    }
}