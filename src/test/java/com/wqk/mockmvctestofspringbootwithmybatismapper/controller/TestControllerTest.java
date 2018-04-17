package com.wqk.mockmvctestofspringbootwithmybatismapper.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.wqk.mockmvctestofspringbootwithmybatismapper.dto.CdnNation;
import com.wqk.mockmvctestofspringbootwithmybatismapper.mapper.TestMapper;
import com.wqk.mockmvctestofspringbootwithmybatismapper.service.TestService;
import com.wqk.mockmvctestofspringbootwithmybatismapper.service.TestServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;


import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMybatis
//@Import(TestServiceImpl.class)
@WebMvcTest(TestController.class)
//@MybatisTest
public class TestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  //if you don't stubbing the specific method, it will use the real method.
  @SpyBean
  private TestServiceImpl testServiceImpl;


  @Test
  public void getCdnNationParams() throws Exception {

    MockHttpServletResponse response = this.mockMvc
        .perform(get("/test/spring/mock/mvc/test/with/mybatis/mapper/v1?year=2018&month=2").accept(MediaType.ALL))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn()
        .getResponse();
    System.out.println("=====mock test result======");
    System.out.println(response.getContentAsString());
  }
}