package com.wqk.mockmvctestofspringbootwithmybatismapper.service;

import com.wqk.mockmvctestofspringbootwithmybatismapper.dto.CdnNation;
import com.wqk.mockmvctestofspringbootwithmybatismapper.mapper.TestMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

  private final TestMapper testMapper;

  public TestServiceImpl(TestMapper testMapper){
    this.testMapper = testMapper;
  }

  @Override
  public List<CdnNation> getCdnNationParams(String year, String month) {
    List<CdnNation> queryResult = testMapper.selectCdnNationAllIndicators(year,month);
    if(queryResult == null){
      queryResult = new ArrayList<>();
    }
    return queryResult;
  }
}
