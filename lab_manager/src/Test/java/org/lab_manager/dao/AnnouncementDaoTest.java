package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by xiaofeige on 2016/5/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class AnnouncementDaoTest {
    @Autowired
    AnnouncementDao adao;

    @Test
    public void queryById() throws Exception {
        Announcement annt=adao.queryById(1);

    }

    @Test
    public void insert() throws Exception {

    }

}