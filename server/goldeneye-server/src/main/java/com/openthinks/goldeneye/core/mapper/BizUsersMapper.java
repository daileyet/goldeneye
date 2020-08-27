package com.openthinks.goldeneye.core.mapper;

import com.openthinks.goldeneye.core.model.BizUsers;
import com.openthinks.goldeneye.core.model.BizUsersExample;
import java.util.List;
import net.sourceforge.orm.mybatis.Page;
import org.apache.ibatis.annotations.Param;

public interface BizUsersMapper {
    long countByExample(BizUsersExample example);

    int deleteByExample(BizUsersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BizUsers record);

    int insertSelective(BizUsers record);

    List<BizUsers> selectByExampleWithRowbounds(BizUsersExample example, Page rowBounds);

    BizUsers selectOneByExample(BizUsersExample example);

    List<BizUsers> selectByExample(BizUsersExample example);

    BizUsers selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BizUsers record, @Param("example") BizUsersExample example);

    int updateByExample(@Param("record") BizUsers record, @Param("example") BizUsersExample example);

    int updateByPrimaryKeySelective(BizUsers record);

    int updateByPrimaryKey(BizUsers record);
}