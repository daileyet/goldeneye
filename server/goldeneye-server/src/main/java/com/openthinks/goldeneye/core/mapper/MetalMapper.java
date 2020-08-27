package com.openthinks.goldeneye.core.mapper;

import com.openthinks.goldeneye.core.model.Metal;
import com.openthinks.goldeneye.core.model.MetalExample;
import java.util.List;
import net.sourceforge.orm.mybatis.Page;
import org.apache.ibatis.annotations.Param;

public interface MetalMapper {
    long countByExample(MetalExample example);

    int deleteByExample(MetalExample example);

    int deleteByPrimaryKey(String code);

    int insert(Metal record);

    int insertSelective(Metal record);

    List<Metal> selectByExampleWithRowbounds(MetalExample example, Page rowBounds);

    Metal selectOneByExample(MetalExample example);

    List<Metal> selectByExample(MetalExample example);

    Metal selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") Metal record, @Param("example") MetalExample example);

    int updateByExample(@Param("record") Metal record, @Param("example") MetalExample example);

    int updateByPrimaryKeySelective(Metal record);

    int updateByPrimaryKey(Metal record);
}