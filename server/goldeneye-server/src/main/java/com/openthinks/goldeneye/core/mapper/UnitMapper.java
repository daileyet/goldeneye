package com.openthinks.goldeneye.core.mapper;

import com.openthinks.goldeneye.core.model.Unit;
import com.openthinks.goldeneye.core.model.UnitExample;
import java.util.List;
import net.sourceforge.orm.mybatis.Page;
import org.apache.ibatis.annotations.Param;

public interface UnitMapper {
    long countByExample(UnitExample example);

    int deleteByExample(UnitExample example);

    int deleteByPrimaryKey(String code);

    int insert(Unit record);

    int insertSelective(Unit record);

    List<Unit> selectByExampleWithRowbounds(UnitExample example, Page rowBounds);

    Unit selectOneByExample(UnitExample example);

    List<Unit> selectByExample(UnitExample example);

    Unit selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") Unit record, @Param("example") UnitExample example);

    int updateByExample(@Param("record") Unit record, @Param("example") UnitExample example);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
}