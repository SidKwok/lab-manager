package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.LabInfoDao;
import org.lab_manager.entity.LabInfo;
import org.lab_manager.entity.LabRoom;
import org.lab_manager.service.ILabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaofeige on 2016/5/24.
 */
@Service
public class LabService implements ILabService {
    @Autowired
    LabInfoDao  mLabInfoDao;

    public List<LabInfo> getAllLabRoom(){
        return mLabInfoDao.queryAll();
    }

    /**
     * 新增实验室
     */
    public boolean addLabRoom(LabRoom labRoom){
        return true;
    }


    /**
     * 修改实验室
     */
    public boolean updateLabRoom(LabRoom labRoom){
        return true;
    }

    /**
     * 为实验室增加评论
     */
    public boolean addComment(String roomId,String comment){
        return true;
    }
}
