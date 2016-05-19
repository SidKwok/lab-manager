package org.lab_manager.dao;

import org.lab_manager.model.UseLabDto;

public interface UseLabDtoMapper {
    int deleteByPrimaryKey(Integer roomId);

    int insert(UseLabDto record);

    int insertSelective(UseLabDto record);

    UseLabDto selectByPrimaryKey(Integer roomId);

    int updateByPrimaryKeySelective(UseLabDto record);

    int updateByPrimaryKey(UseLabDto record);
}