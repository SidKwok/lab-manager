package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.Experiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Silence on 2016/5/23.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ExperimentDaoTest {
    @Autowired
    private ExperimentDao ed;
    @Test
    public void addExperiment() throws Exception {
        ed.addExperiment("222","C++","111131",2,"805","Luo","2013","2016");
    }

    @Test
    public void queryById() throws Exception {
        Experiment e=ed.queryById("001");
        System.out.println(e.getCourse_name());
    }
}