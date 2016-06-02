package org.lab_manager.dao;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.Attendence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Silence on 2016/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class AttendenceDaoTest {
    @Autowired
    AttendenceDao attendenceDao;
    @Test
    public void getAllAttendence() throws Exception {
        List<Attendence> list=attendenceDao.getAllAttendence();
        for (Attendence attendence:list){
            System.out.println(attendence.getDate());
        }
    }
    @Test
    public void getAttendenceById() throws Exception{
        List<Attendence> list=attendenceDao.getAttendenceById("20131000000");
        for (Attendence attendence:list){
            System.out.println(attendence.getDate());
        }
    }

}