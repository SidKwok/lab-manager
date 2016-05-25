package org.lab_manager.dao;

import org.junit.Test;
import org.lab_manager.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Silence on 2016/5/24.
 */
public class AnnouncementDaoTest {
    @Autowired
    AnnouncementDao announcementDao;
    @Test
    public void queryById() throws Exception {
        Announcement announcement = announcementDao.queryById(1);
        System.out.println(announcement.getContent());
    }

}