package pers.will.mp;

import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.will.mp.mapper.UserMapper;
import pers.will.mp.pojo.Test;
import pers.will.mp.service.JdbcService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MpDemoApplicationTests {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  JdbcService  service;
  @org.junit.Test
  public void contextLoads()throws Exception {
    service.testJdbc();
    Test test = new Test();
    List<Test> tests = userMapper.selectList(null);
    tests.forEach(System.out::println);
  }

}
