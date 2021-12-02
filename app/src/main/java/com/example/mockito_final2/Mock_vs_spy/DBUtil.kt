package test_doubles.Mock_vs_spy

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


object DBUtil {
    private const val DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"
    private const val DB_USERNAME = "root"
    private const val DB_PASSWORD = "root"
    private const val DB_URL = "jdbc:mysql://localhost:3306/test"
    var connection: Connection? = null
        private set

    init {
        try {
            Class.forName(DB_DRIVER_CLASS)
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
}