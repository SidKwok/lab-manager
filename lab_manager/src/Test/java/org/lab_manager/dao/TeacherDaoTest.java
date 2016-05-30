package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.Student;
import org.lab_manager.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Silence on 2016/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TeacherDaoTest {
    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void queryById() throws Exception {
        Teacher teacher = teacherDao.queryById("001");
        System.out.println(teacher.getName());
    }
    @Test
    public void getAllStudent() throws Exception{
        List<Student> list=teacherDao.getAllStudent("001");
        for (Student student:list){
            System.out.println(student.getSName());
        }
    }
}