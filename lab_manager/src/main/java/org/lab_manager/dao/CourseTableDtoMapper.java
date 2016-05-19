package org.lab_manager.dao;

import org.lab_manager.model.CourseTableDto;

public interface CourseTableDtoMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(CourseTableDto record);

    int insertSelective(CourseTableDto record);

    CourseTableDto selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(CourseTableDto record);

    int updateByPrimaryKey(CourseTableDto record);
}