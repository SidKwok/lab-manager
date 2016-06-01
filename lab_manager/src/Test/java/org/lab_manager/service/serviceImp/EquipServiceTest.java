package org.lab_manager.service.serviceImp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.service.IEquipService;
import org.lab_manager.service.IExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by xiaofeige on 2016/5/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class EquipServiceTest {
    @Autowired
    IEquipService equipService;

    @Test
    public void addEquipOrder() throws Exception {
        equipService.addEquipOrder("狼牙棒",3,"2","3","T001");
    }

    @Test
    public void getAllEquipInfo() throws Exception {

    }

    @Test
    public void queryEquipById() throws Exception {

    }

    @Test
    public void updateEquipInfo() throws Exception {

    }

    @Test
    public void addEquip() throws Exception {

    }

    @Test
    public void deleteEquipById() throws Exception {

    }

}