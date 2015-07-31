package bananalighter.mysql

import java.sql.{ResultSet, DriverManager}

/**
 * Created by root on 15-7-30.
 */
object MySQLConnectionUtil {
  def getTable(): ResultSet = {

    val conn_string = "jdbc:mysql://172.19.17.211:3306/test?user=root&password=root"
    classOf[com.mysql.jdbc.Driver]
    val conn = DriverManager.getConnection(conn_string)
    val statement = conn.createStatement()
    // Execute Query
    val rs = statement.executeQuery("select * from parquet;")
    return rs
  }

}
