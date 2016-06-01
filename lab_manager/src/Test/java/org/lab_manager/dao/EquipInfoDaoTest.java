package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.EquipInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Silence on 2016/5/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class EquipInfoDaoTest {
    @Autowired
    EquipInfoDao equipInfoDao;
    @Test
    public void queryById() throws Exception {

    }

    @Test
    public void getAllAssects() throws Exception {
        List<EquipInfo> list = equipInfoDao.getAllAssets();
        for (EquipInfo equipInfo:list){
            System.out.println(equipInfo.getAsset_name());
        }
    }

    @Test
    public void getAssetInfo() throws Exception{
        EquipInfo equipInfo=equipInfoDao.getAssetInfo("西瓜刀");
        System.out.println(equipInfo.getCharge_type());
    }

    @Test
    public void updateAsset() throws Exception{
//        boolean status = equipInfoDao.updateAsset("西瓜刀",2,"刀","大资产",30);
    }

    @Test
    public void deleteAsset()throws Exception{
        boolean status= equipInfoDao.deleteAsset("101");
        System.out.println(status);
    }
    @Test
    public void addAsset() throws Exception{
        boolean status=equipInfoDao.addAsset("12",123,"123","12","12","12",12,1,"12","12","12","12","12","12","12","12","12","12","12","12","12","12","12","12","12","12","12","12","12","12","12","12",12,"12");
        System.out.println(status);
    }
    @Test
    public void insert() throws Exception{
        boolean status=equipInfoDao.insert("高级计算机",130021,"计算机","工具",20);
    }
}