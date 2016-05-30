package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.LabUse;
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
public class LabUseDaoTest {
    @Autowired
    LabUseDao labUseDao;
    @Test
    public void getLabUseInfo() throws Exception {
        List<LabUse> list = labUseDao.getLabUseInfo(805);
        for(LabUse labUse:list){
            System.out.println(labUse.getApplicant());
        }
    }

}