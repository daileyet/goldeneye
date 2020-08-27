package com.openthinks.goldeneye.core.mapper;

import com.openthinks.goldeneye.core.model.GoldPriceHistory;
import com.openthinks.goldeneye.core.model.GoldPriceHistoryExample;
import java.util.List;
import net.sourceforge.orm.mybatis.Page;
import org.apache.ibatis.annotations.Param;

public interface GoldPriceHistoryMapper {
    long countByExample(GoldPriceHistoryExample example);

    int deleteByExample(GoldPriceHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoldPriceHistory record);

    int insertSelective(GoldPriceHistory record);

    List<GoldPriceHistory> selectByExampleWithRowbounds(GoldPriceHistoryExample example, Page rowBounds);

    GoldPriceHistory selectOneByExample(GoldPriceHistoryExample example);

    List<GoldPriceHistory> selectByExample(GoldPriceHistoryExample example);

    GoldPriceHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoldPriceHistory record, @Param("example") GoldPriceHistoryExample example);

    int updateByExample(@Param("record") GoldPriceHistory record, @Param("example") GoldPriceHistoryExample example);

    int updateByPrimaryKeySelective(GoldPriceHistory record);

    int updateByPrimaryKey(GoldPriceHistory record);
}