package org.lab_manager.dao;

import org.junit.Test;
import org.lab_manager.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Silence on 2016/5/24.
 */
public class TeacherDaoTest {
    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void queryById() throws Exception {
        Teacher teacher = teacherDao.queryById("001");
        System.out.println(teacher.getName());
    }
}