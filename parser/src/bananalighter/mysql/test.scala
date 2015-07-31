package bananalighter.mysql

import java.sql.ResultSet

/**
 * Created by root on 15-7-30.
 */
object test {

  def main(args: Array[String]) {
    try {
      val rs = MySQLConnectionUtil.getTable()
      if(rs.next())
      printf(rs.getString("content"))
    }
  }
}
