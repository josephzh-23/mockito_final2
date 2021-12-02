package test_doubles.Mock_vs_spy

interface EmployeeDAO {
    fun createEmployee(employee: Employee?)
    fun getEmployeeById(employeeId: Int?): Employee?
    fun updateEmployeeEmailById(newEmail: String?, employeeId: Int?)
    fun deleteEmployeeById(employeeId: Int?)
    val allEmployeesInfo: List<Employee?>?
}