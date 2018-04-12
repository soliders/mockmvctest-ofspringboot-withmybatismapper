package com.wqk.mockmvctestofspringbootwithmybatismapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wqk.mockmvctestofspringbootwithmybatismapper.mapper")
@SpringBootApplication
public class MockmvctestOfspringbootWithmybatismapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockmvctestOfspringbootWithmybatismapperApplication.class, args);
	}
}
