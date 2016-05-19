package org.lab_manager.dao;

import org.lab_manager.model.ManageLabDto;

public interface ManageLabDtoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ManageLabDto record);

    int insertSelective(ManageLabDto record);

    ManageLabDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManageLabDto record);

    int updateByPrimaryKey(ManageLabDto record);
}