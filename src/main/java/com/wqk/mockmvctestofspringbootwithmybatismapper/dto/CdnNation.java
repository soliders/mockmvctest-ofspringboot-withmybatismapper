package com.wqk.mockmvctestofspringbootwithmybatismapper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CdnNation {
  private String year;
  private String month;
  private String bandWidthPeak;
  private String bandWidthMean;
  private String totalServeProvinces;
  private String totalDomainNums;
}
