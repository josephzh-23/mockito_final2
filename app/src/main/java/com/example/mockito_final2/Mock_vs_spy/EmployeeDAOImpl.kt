package test_doubles.Mock_vs_spy

import java.sql.Date
import java.sql.ResultSet


class EmployeeDAOImpl : EmployeeDAO {
	override fun createEmployee(employee: Employee?) {
		val SQL = "INSERT INTO employee_table(employee_name,email,salary,date_of_joining,bonus)VALUES(?,?,?,?,?)"
		try {
			DBUtil.connection!!.use { connection ->
				connection.prepareStatement(SQL).use { ps ->
					ps.setString(1, employee!!.employeeName)
					ps.setString(2, employee.email)
					employee.salary?.let { ps.setDouble(3, it) }
					ps.setDate(4, Date(employee.doj!!.time))
					ps.setBigDecimal(5, employee.bonus)
					val executeUpdate: Int = ps.executeUpdate()
					if (executeUpdate == 1) {
						println("Employee is crated..")
					}
				}
			}
		} catch (e: Exception) {
			e.printStackTrace()
		}
	}

	override fun getEmployeeById(employeeId: Int?): Employee? {
		var employee: Employee? = null
		val SQL = "SELECT *FROM employee_table WHERE employee_id=?"
		try {
			DBUtil.connection!!.use { connection ->
				connection.prepareStatement(SQL).use { ps ->
					if (employeeId != null) {
						ps.setInt(1, employeeId)
					}
					val rs: ResultSet = ps.executeQuery()
					if (rs.next()) {
						val empId = rs.getInt("employee_id")
						val eName = rs.getString("employee_name")
						val email = rs.getString("email")
						val salary = rs.getDouble("salary")
						val bonus = rs.getBigDecimal("bonus")
						val date = rs.getDate("date_of_joining")
						employee = Employee()
						employee!!.employeeName = eName
						employee!!.bonus = bonus
						employee!!.doj = date
						employee!!.email = email
						employee!!.employee_id = empId
						employee!!.salary = salary
					}
				}
			}
		} catch (e: Exception) {
			e.printStackTrace()
		}
		return employee
	}

	override fun updateEmployeeEmailById(newEmail: String?, employeeId: Int?) {
		val SQL = "UPDATE employee_table set email=? WHERE employee_id=?;"
		try {
			DBUtil.connection!!.use { connection ->
				connection.prepareStatement(SQL).use { ps ->
					ps.setString(1, newEmail)
					if (employeeId != null) {
						ps.setInt(2, employeeId)
					}
					val executeUpdate: Int = ps.executeUpdate()
					if (executeUpdate == 1) {
						println("Employee email is updated..")
					}
				}
			}
		} catch (e: Exception) {
			e.printStackTrace()
		}
	}

	override fun deleteEmployeeById(employeeId: Int?) {
		val SQL = "DELETE FROM employee_table WHERE employee_id=?;"
		try {
			DBUtil.connection!!.use { connection ->
				connection.prepareStatement(SQL).use { ps ->
					if (employeeId != null) {
						ps.setInt(1, employeeId)
					}
					val executeUpdate: Int = ps.executeUpdate()
					if (executeUpdate == 1) {
						println("Employee is deleted with ID::$employeeId")
					}
				}
			}
		} catch (e: Exception) {
			e.printStackTrace()
		}
	}

	override val allEmployeesInfo: List<Employee>
		get() {
			val empList: MutableList<Employee> = ArrayList()
			val SQL = "SELECT *FROM employee_table"
			try {
				DBUtil.connection!!.use { connection ->
					connection.prepareStatement(SQL).use { ps ->
						val rs: ResultSet = ps.executeQuery()
						while (rs.next()) {
							val empId = rs.getInt("employee_id")
							val eName = rs.getString("employee_name")
							val email = rs.getString("email")
							val salary = rs.getDouble("salary")
							val bonus = rs.getBigDecimal("bonus")
							val date = rs.getDate("date_of_joining")
							val employee = Employee()
							employee.employeeName = eName
							employee.bonus = bonus
							employee.doj = date
							employee.email = email
							employee.employee_id = empId
							employee.salary = salary
							empList.add(employee)
						}
					}
				}
			} catch (e: Exception) {
				e.printStackTrace()
			}
			return empList
		}
}