package com.wqk.mockmvctestofspringbootwithmybatismapper.service;

import com.wqk.mockmvctestofspringbootwithmybatismapper.dto.CdnNation;
import java.util.List;

public interface TestService {

  List<CdnNation> getCdnNationParams(String year,String month);
}
