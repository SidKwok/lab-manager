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

}