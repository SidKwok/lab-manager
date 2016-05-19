package org.lab_manager.dao;

import org.lab_manager.model.OrderTableDto;

public interface OrderTableDtoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderTableDto record);

    int insertSelective(OrderTableDto record);

    OrderTableDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderTableDto record);

    int updateByPrimaryKey(OrderTableDto record);
}