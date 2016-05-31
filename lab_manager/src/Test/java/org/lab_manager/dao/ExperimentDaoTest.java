package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.Experiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xiaofeige on 2016/5/23.
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
    @Test
    public void applyExperiment() throws Exception{
        boolean b = ed.applyExperiment("大实习",805,"张","第八周","第十八周","周五","三四节");
        System.out.println(b);
    }
    @Test
    public void queryAllExperimentOrderState() throws Exception{
        List<Experiment> list = ed.queryAllExperimentOrderState();
        for (Experiment experiment:list){
            System.out.println(experiment.getCourse_name());
        }
    }
    @Test
    public void getExperimentsByRoomID() throws Exception{
        List<Experiment> list=ed.getExperimentsByRoomID("805");
        for (Experiment experiment:list){
            System.out.println(experiment.getCourse_name());
        }
    }
    @Test
    public void approveApply() throws Exception{
        boolean status=ed.approveApply(1);
        System.out.println(status);
    }
    @Test
    public void refuseApply() throws Exception{
        boolean status=ed.refuseApply(1);
        System.out.println(status);
    }
}