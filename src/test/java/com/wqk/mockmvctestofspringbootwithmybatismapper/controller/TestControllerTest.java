package com.wqk.mockmvctestofspringbootwithmybatismapper.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.wqk.mockmvctestofspringbootwithmybatismapper.dto.CdnNation;
import com.wqk.mockmvctestofspringbootwithmybatismapper.mapper.TestMapper;
import com.wqk.mockmvctestofspringbootwithmybatismapper.service.TestService;
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
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;


import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
//@MybatisTest
@AutoConfigureMybatis
@WebMvcTest(TestController.class)
public class TestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TestService testService;
  //通过MockBean来mock Mapper,这样可以通过测试，但是失去了真实的Mapper文件读取数据库的能力。无法对service层的实现逻辑进行单元测试。
  //@MockBean
  //private TestMapper testMapper;
  //使用@AutoConfigureMybatis也可以通过测试，但是无法获取真正的Mapper操作获取的数据。
  //@AutoConfigureMybatis


  @Test
  public void getCdnNationParams() throws Exception {
    List<CdnNation> serviceResults = new ArrayList<>();
    /*serviceResults.add(
        CdnNation.builder().year("2018").month("2").bandWidthMean("24.33").bandWidthPeak("33.33")
            .totalDomainNums("44").totalServeProvinces("76").build());*/
    when(testService.getCdnNationParams("2018", "2")).thenReturn(serviceResults);

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