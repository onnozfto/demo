package pers.will.mp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description
 * @Author will
 * @Date 2019/09/05
 */
public class JDBCUtils {

  static {
    try {

      Class.forName("com.mysql.jdbc.Driver");
    } catch (Exception e) {

    }
  }

  private static final String URL = "jdbc:mysql://localhost:3306/test";

  private static final String USERNAME = "root";

  private static final String PASSWORD = "root";

  public static Connection getConnection() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

}
