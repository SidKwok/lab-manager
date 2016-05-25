package org.lab_manager.service.serviceImp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab_manager.entity.LabInfo;
import org.lab_manager.service.ILabService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xiaofeige on 2016/5/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class LabServiceTest {

    @Resource
    private ILabService labService;
    @Test
    public void getAllLabRoom() throws Exception {
        List<LabInfo> all = labService.getAllLabRoom();
        System.out.println(all);
    }

}