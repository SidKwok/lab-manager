package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.LabOrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Silence on 2016/5/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class LabOrderStateDaoTest {
    @Autowired
    LabOrderStateDao labOrderStateDao;
    @Test
    public void getLabOrderState() throws Exception {
        List<LabOrderState> list = labOrderStateDao.getLabOrderState("admin");
        for (LabOrderState labOrderState:list){
            System.out.println(labOrderState.getOrder_date());
        }
    }
    @Test
    public void getEquipOrderState() throws  Exception{
        List<LabOrderState> list = labOrderStateDao.getEquipOrderState("admin");
        for (LabOrderState labOrderState:list){
            System.out.println(labOrderState.getOrder_date());
        }
    }
}