package com.wqk.mockmvctestofspringbootwithmybatismapper.mapper;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TestMapperProvider {


  private final static String TABLE_NAME = "komect_data_product_abilityopen_cdnnation";

  public String selectCdnNationAllIndicators(Map<String, Object> parameters) {
    return new SQL() {
      {
        SELECT(
            "year,month,bandwidth_peak,bandwidth_mean,total_serve_provinces,total_domain_nums");
        FROM(TABLE_NAME);
        WHERE("(month <= #{month} and year = #{year}) or (year < #{year})");
        ORDER_BY("year desc ,month desc");
      }
    }.toString();
  }
}
