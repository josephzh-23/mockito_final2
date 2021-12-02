package test_doubles.Mock_vs_spy




class EmployeeServiceImpl : EmpoyeeService {
    private val employeeDAO: EmployeeDAO = EmployeeDAOImpl()
    override fun createEmployee(employee: Employee?) {
        employeeDAO.createEmployee(employee)
    }

    override fun fetchEmployeeById(employeeId: Int?): Employee? {
        return employeeDAO.getEmployeeById(employeeId)
    }

    override fun updateEmployeeEmailById(newEmail: String?, employeeId: Int?) {
        employeeDAO.updateEmployeeEmailById(newEmail, employeeId)
    }

    override fun deleteEmployeeById(employeeId: Int?) {
        employeeDAO.deleteEmployeeById(employeeId)
    }

    override fun fetchAllEmployeesInfo(): List<Employee?>? {
        return employeeDAO.allEmployeesInfo
    }
}