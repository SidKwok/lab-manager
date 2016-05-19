package org.lab_manager.dao;

import org.lab_manager.model.UsrTableDto;

public interface UsrTableDtoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsrTableDto record);

    int insertSelective(UsrTableDto record);

    UsrTableDto selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsrTableDto record);

    int updateByPrimaryKey(UsrTableDto record);
}