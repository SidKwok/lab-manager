package org.lab_manager.dao;

import org.lab_manager.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/17.
 */
@Repository
public interface StudentDao {
    public Student queryById(String id);
    /*
    获取所有学生的信息
     */
    public List<Student> queryAllStudent();
}
