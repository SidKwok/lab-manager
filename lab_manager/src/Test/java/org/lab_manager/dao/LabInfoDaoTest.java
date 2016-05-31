package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.LabInfo;
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
public class LabInfoDaoTest {
    @Autowired
    LabInfoDao labInfoDao;
    @Test
    public void getLabInfo() throws Exception {
//        LabInfo labInfo=labInfoDao.getLabInfo("软工实验室");
//        System.out.println(labInfo.getIntro());
    }

    @Test
    public void getAllLabInfo() throws Exception {
        List<LabInfo> list = labInfoDao.getAllLabInfo();
        for (LabInfo labInfo:list){
            System.out.println(labInfo.getRoom_name());
        }
    }

    @Test
    public void updateLab() throws  Exception{
//        boolean status=labInfoDao.updateLab("软工实验室","张","软件工程实验室还不错哦");
//        System.out.println(status);
    }

    @Test
    public void deleteLab() throws Exception{
//        boolean status=labInfoDao.deleteLab("软工实验室");
//        System.out.println(status);
    }
    @Test
    public void addLab() throws Exception{
        boolean status=labInfoDao.addLab(412,"java实验室","杨","专业java培训");
        System.out.println(status);
    }
}