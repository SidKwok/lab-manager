package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.LabComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Silence on 2016/5/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class LabCommentDaoTest {
    @Autowired
    LabCommentDao labCommentDao;

    @Test
    public void getLabComment() throws Exception {
        List<LabComment> List = labCommentDao.getAllComment(1);
        for (LabComment labComment:List) {
            System.out.println(labComment.getComment());
        }
    }
    @Test
    public void addLabComment() throws Exception{
        boolean status = labCommentDao.addComment(2,"觉得还不错吧");
        System.out.println(status);
    }
}