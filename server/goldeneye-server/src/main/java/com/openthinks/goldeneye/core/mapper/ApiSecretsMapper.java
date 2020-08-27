package com.openthinks.goldeneye.core.mapper;

import com.openthinks.goldeneye.core.model.ApiSecrets;
import com.openthinks.goldeneye.core.model.ApiSecretsExample;
import java.util.List;
import net.sourceforge.orm.mybatis.Page;
import org.apache.ibatis.annotations.Param;

public interface ApiSecretsMapper {
    long countByExample(ApiSecretsExample example);

    int deleteByExample(ApiSecretsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApiSecrets record);

    int insertSelective(ApiSecrets record);

    List<ApiSecrets> selectByExampleWithRowbounds(ApiSecretsExample example, Page rowBounds);

    ApiSecrets selectOneByExample(ApiSecretsExample example);

    List<ApiSecrets> selectByExample(ApiSecretsExample example);

    ApiSecrets selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApiSecrets record, @Param("example") ApiSecretsExample example);

    int updateByExample(@Param("record") ApiSecrets record, @Param("example") ApiSecretsExample example);

    int updateByPrimaryKeySelective(ApiSecrets record);

    int updateByPrimaryKey(ApiSecrets record);
}