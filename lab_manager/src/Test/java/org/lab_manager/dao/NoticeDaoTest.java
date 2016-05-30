package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Silence on 2016/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class NoticeDaoTest {
    @Autowired
    NoticeDao noticeDao;
    @Test
    public void queryById() throws Exception {
        Notice notice = noticeDao.queryById(1);
        System.out.println(notice.getContent());
    }
    @Test
    public void getAllNotice() throws  Exception{
        List<Notice> list = noticeDao.getAllNotice();
        for (Notice notice:list){
            System.out.println(notice.getDate());
        }
    }
    @Test
    public void addNotice() throws Exception{
        boolean status = noticeDao.addNotice("2016-5-30","最新公告：明天放假！","王");
        System.out.println(status);
    }
}