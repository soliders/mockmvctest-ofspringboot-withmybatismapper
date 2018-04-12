package com.wqk.mockmvctestofspringbootwithmybatismapper.mapper;

import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wqk.mockmvctestofspringbootwithmybatismapper.dto.CdnNation;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestMapperTest {

  @Autowired
  private TestMapper testMapper;

  @Test
  public void selectCdnNationAllIndicatorsTest() throws JsonProcessingException {
    List<CdnNation> results = testMapper.selectCdnNationAllIndicators("2018","2");
    System.out.println("==========Mapper Test 结果==========");
    ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(results.size());
    System.out.println(objectMapper.writeValueAsString(results.get(0)));
    System.out.println(results.get(1).getBandWidthMean());
  }

}