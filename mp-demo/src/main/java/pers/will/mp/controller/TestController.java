package pers.will.mp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.will.mp.mapper.UserMapper;
import pers.will.mp.pojo.Test;

/**
 * @Description
 * @Author will
 * @Date 2019/09/10
 */
@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  UserMapper userMapper;

  @GetMapping("/user")
  public String get() {
    QueryWrapper<Test> testCriteria= new QueryWrapper<>();
    testCriteria.select(Test.class, tableFieldInfo -> tableFieldInfo.isSelect());
    testCriteria.and( wrapper -> wrapper.eq("id", 1));
    List<Test> tests = userMapper.selectList(testCriteria);
    return tests.toString();
  }
}
