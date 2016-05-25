package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Silence on 2016/5/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void queryById() throws Exception {
        Student student = studentDao.queryById("20131003261");
        System.out.println(student.getSName());
    }
}