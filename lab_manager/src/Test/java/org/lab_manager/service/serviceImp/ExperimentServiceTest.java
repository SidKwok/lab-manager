package org.lab_manager.service.serviceImp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.service.IExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by xiaofeige on 2016/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")

public class ExperimentServiceTest {
    @Autowired
    IExperimentService experimentService;

    @Test
    public void applyExp() throws Exception {
        experimentService.applyExp("nihao",1,"T001","第八周","第十周","周三","2,3节");
    }

}