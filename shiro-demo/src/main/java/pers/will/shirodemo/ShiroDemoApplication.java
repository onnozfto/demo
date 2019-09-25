package pers.will.shirodemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "pers.will.shirodemo.mapper")
public class ShiroDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShiroDemoApplication.class, args);
  }

}
