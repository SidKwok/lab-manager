package org.lab_manager.dao;

import org.junit.Test;

import org.lab_manager.entity.Student;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiaofeige on 2016/5/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/spring-config.xml")
public class StudentDaoTest {
    @Autowired
    private StudentDao mStudentDao;

    @Test
    public void queryById() throws Exception {
        Student s=mStudentDao.queryById("20131003261");
        if(s!=null){
            System.out.println(s.getSName());
        }
        else{
            System.out.println("target not found");
        }
    }

}