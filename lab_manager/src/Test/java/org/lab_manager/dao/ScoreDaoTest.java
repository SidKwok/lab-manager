package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Silence on 2016/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ScoreDaoTest {
    @Autowired
    ScoreDao scoreDao;
    @Test
    public void getScoreBySNO() throws Exception {
        List<Score> list=scoreDao.getScoreBySNO("20131004222");
        for (Score score:list){
            System.out.println(score.getCourse_name());
        }
    }
    @Test
    public void updateScore() throws Exception{
        boolean status=scoreDao.updateScore("20131004222","软件测试","89");
        System.out.println(status);
    }

    @Test
    public void insertScore()throws Exception{
        boolean status=scoreDao.insertScore("20131002111","软件测试","90");
        System.out.println(status);
    }
}