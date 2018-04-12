package com.wqk.mockmvctestofspringbootwithmybatismapper.controller;

import com.wqk.mockmvctestofspringbootwithmybatismapper.dto.CdnNation;
import com.wqk.mockmvctestofspringbootwithmybatismapper.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "AbilityOpenController", description = "xxxAPI")
public class TestController {


  private final TestService testService;

  public TestController(TestService testService) {
    this.testService = testService;
  }

  @GetMapping("/test/spring/mock/mvc/test/with/mybatis/mapper/v{version}")
  @ApiOperation(value = "xx[已经实现]", notes = "xxx", httpMethod = "GET")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "version", value = "版本号，例：1", required = true, paramType = "path", dataType = "String"),
      @ApiImplicitParam(name = "year", value = "年，例：2018", required = true, paramType = "query", dataType = "String"),
      @ApiImplicitParam(name = "month", value = "月，例：1", required = true, paramType = "query", dataType = "String"),
  })
  @ApiResponses({
      //@ApiResponse(code = 500, message = "内部服务异常，请联系管理员")
  })
  public List<CdnNation> getCdnNationParams(
      @PathVariable(value = "version") String version, @RequestParam("year") String year,
      @RequestParam("month") String month) {
    switch (version) {
      case "1":
        return testService.getCdnNationParams(year, month);
      default:
        return testService.getCdnNationParams(year, month);
    }
  }
}
