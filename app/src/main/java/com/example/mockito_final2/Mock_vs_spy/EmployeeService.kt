package test_doubles.Mock_vs_spy


interface EmpoyeeService {
    fun createEmployee(employee: Employee?)
    fun fetchEmployeeById(employeeId: Int?): Employee?
    fun updateEmployeeEmailById(newEmail: String?, employeeId: Int?)
    fun deleteEmployeeById(employeeId: Int?)
    fun fetchAllEmployeesInfo(): List<Employee?>?
}