package com.openthinks.goldeneye.core.mapper;

import com.openthinks.goldeneye.core.model.MetalPriceHistory;
import com.openthinks.goldeneye.core.model.MetalPriceHistoryExample;
import java.util.List;
import net.sourceforge.orm.mybatis.Page;
import org.apache.ibatis.annotations.Param;

public interface MetalPriceHistoryMapper {
    long countByExample(MetalPriceHistoryExample example);

    int deleteByExample(MetalPriceHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MetalPriceHistory record);

    int insertSelective(MetalPriceHistory record);

    List<MetalPriceHistory> selectByExampleWithRowbounds(MetalPriceHistoryExample example, Page rowBounds);

    MetalPriceHistory selectOneByExample(MetalPriceHistoryExample example);

    List<MetalPriceHistory> selectByExample(MetalPriceHistoryExample example);

    MetalPriceHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MetalPriceHistory record, @Param("example") MetalPriceHistoryExample example);

    int updateByExample(@Param("record") MetalPriceHistory record, @Param("example") MetalPriceHistoryExample example);

    int updateByPrimaryKeySelective(MetalPriceHistory record);

    int updateByPrimaryKey(MetalPriceHistory record);
}