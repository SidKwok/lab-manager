package org.lab_manager.dao;

import org.junit.Test;
import org.lab_manager.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Silence on 2016/5/24.
 */
public class NoticeDaoTest {
    @Autowired
    NoticeDao noticeDao;
    @Test
    public void queryById() throws Exception {
        Notice notice = noticeDao.queryById(1);
        System.out.println(notice.getContent());
    }

}