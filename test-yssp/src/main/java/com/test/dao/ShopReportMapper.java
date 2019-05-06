package com.test.dao;

import com.test.pojo.ShopReport;
import com.test.pojo.ShopReportExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopReportMapper {
    int countByExample(ShopReportExample example);

    int deleteByExample(ShopReportExample example);

    int deleteByPrimaryKey(Integer reportId);

    int insert(ShopReport record);

    int insertSelective(ShopReport record);

    List<ShopReport> selectByExample(ShopReportExample example);

    ShopReport selectByPrimaryKey(Integer reportId);

    int updateByExampleSelective(@Param("record") ShopReport record, @Param("example") ShopReportExample example);

    int updateByExample(@Param("record") ShopReport record, @Param("example") ShopReportExample example);

    int updateByPrimaryKeySelective(ShopReport record);

    int updateByPrimaryKey(ShopReport record);

    List<ShopReport> findAllUser();

    ShopReport selectByPojo(@Param("reportName")String reportName,@Param("reportPhone")String reportPhone);
}