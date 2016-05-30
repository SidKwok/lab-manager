package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.EquipInfo;
import org.lab_manager.entity.EquipOrder;
import org.lab_manager.entity.LabInfo;
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
public class EquipOrderDaoTest {
    @Autowired
    EquipOrderDao equipOrderDao;
    @Test
    public void orderEquip() throws Exception {
        boolean status = equipOrderDao.orderEquip("键盘",2,3,"王");
        System.out.println(status);
    }
    @Test
    public void getAllEquipOrderStatus()throws Exception{
        List<EquipOrder> list = equipOrderDao.getAllEquipOrderStatus();
        for (EquipOrder equipOrder:list){
            System.out.println(equipOrder.getApplicant());
        }
    }
    @Test
    public void approveOrder() throws Exception{
        boolean status=equipOrderDao.approveEquipOrder(1);
        System.out.println(status);
    }

    @Test
    public void refuseOrder() throws Exception{
        boolean status=equipOrderDao.refuseEquipOrder(1);
        System.out.println(status);
    }
}