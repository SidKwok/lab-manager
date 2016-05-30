package org.lab_manager.dao;

import org.lab_manager.entity.Teacher;
import org.springframework.stereotype.Repository;

/**
 * Created by Silence on 2016/5/24.
 */
@Repository
public interface TeacherDao {
    public Teacher queryById(String id);
}
