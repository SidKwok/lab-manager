package org.lab_manager.dao;

import org.lab_manager.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by xiaofeige on 2016/5/17.
 */
@Repository
public interface StudentDao {
    public Student queryById(String id);
    public Student queryByIdAndName(@Param("id") String id,@Param("name") String name);
}
