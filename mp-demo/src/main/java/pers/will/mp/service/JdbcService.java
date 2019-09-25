package pers.will.mp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.stereotype.Service;
import pers.will.mp.utils.JDBCUtils;

/**
 * @Description
 * @Author will
 * @Date 2019/09/05
 */
@Service
public class JdbcService {


  public void testJdbc()throws  Exception {

    Connection con = JDBCUtils.getConnection();
    Statement statement = con.createStatement();
    PreparedStatement ps = con.prepareStatement("select * from user ");
    ps.executeQuery();
    ResultSet rs = ps.getResultSet();
    while (rs.next()) {
      System.out.println(rs);
    }
  }

}
