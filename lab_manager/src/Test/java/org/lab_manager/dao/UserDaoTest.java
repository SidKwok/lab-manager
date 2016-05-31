package org.lab_manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.Role;
import org.lab_manager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Silence on 2016/5/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class UserDaoTest {
    @Test
    public void getRole() throws Exception {

        System.out.println(userDao.getRoleId("T001","123"));
    }

    @Test
    public void getRoleId() throws Exception {
        Role r=userDao.getRole("2");
        System.out.println(r.getRole_name());
    }

    @Autowired
    UserDao userDao;
    @Test
    public void login() throws Exception {

    }

}