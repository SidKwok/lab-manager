package org.lab_manager.dao;

import org.lab_manager.model.DeviceTypeInDto;

public interface DeviceTypeInDtoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeviceTypeInDto record);

    int insertSelective(DeviceTypeInDto record);

    DeviceTypeInDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeviceTypeInDto record);

    int updateByPrimaryKey(DeviceTypeInDto record);
}