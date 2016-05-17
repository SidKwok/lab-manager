package org.lab_manager.dao;

import org.lab_manager.entity.Student;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xiaofeige on 2016/5/17.
 */
public interface StudentDao {
    public Student queryById(String id);
    public Student queryByIdAndName(@Param("id") int id,@Param("name") String name);
}
