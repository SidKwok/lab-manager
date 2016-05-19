package org.lab_manager.dao;

import org.lab_manager.model.ChkOnTblDto;

public interface ChkOnTblDtoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChkOnTblDto record);

    int insertSelective(ChkOnTblDto record);

    ChkOnTblDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChkOnTblDto record);

    int updateByPrimaryKey(ChkOnTblDto record);
}