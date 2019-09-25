package pers.will.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pers.will.mp.mapper")
public class MpDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MpDemoApplication.class, args);
  }

}
