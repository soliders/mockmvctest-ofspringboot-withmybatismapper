package com.wqk.mockmvctestofspringbootwithmybatismapper.mapper;

import com.wqk.mockmvctestofspringbootwithmybatismapper.dto.CdnNation;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {

  /**
   * @see TestMapperProvider#selectCdnNationAllIndicators(Map)
   * @param year
   * @param month
   * @return
   */
  @Results(value = {
      @Result(property = "year", column = "year", javaType = String.class, jdbcType = JdbcType.INTEGER),
      @Result(property = "month", column = "month", javaType = String.class, jdbcType = JdbcType.INTEGER),
      @Result(property = "bandWidthPeak", column = "bandwidth_peak", javaType = String.class, jdbcType = JdbcType.DOUBLE),
      @Result(property = "bandWidthMean", column = "bandwidth_mean", javaType = String.class, jdbcType = JdbcType.DOUBLE),
      @Result(property = "totalServeProvinces", column = "total_serve_provinces", javaType = String.class, jdbcType = JdbcType.DOUBLE),
      @Result(property = "totalDomainNums", column = "total_domain_nums", javaType = String.class, jdbcType = JdbcType.DOUBLE),
  })
  @SelectProvider(type = TestMapperProvider.class, method = "selectCdnNationAllIndicators")
  List<CdnNation> selectCdnNationAllIndicators(@Param("year") String year,
      @Param("month") String month);
}
