package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.LabInfoDao;
import org.lab_manager.entity.LabComment;
import org.lab_manager.entity.LabInfo;
import org.lab_manager.entity.LabRoom;
import org.lab_manager.entity.LabUse;
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
    private LabInfoDao  mLabInfoDao;

    @Override
    public List<LabInfo> getAllLabRoom(){
        return mLabInfoDao.getAllLabInfo();
    }

    @Override
    public boolean addLabRoom(LabRoom labRoom) {
        return false;
    }

    @Override
    public boolean updateLabRoom(LabRoom labRoom) {
        return false;
    }

    @Override
    public boolean addComment(LabComment comment) {
        return false;
    }

    @Override
    public List<LabComment> getLabComment(String roomId) {
        return null;
    }

    @Override
    public List<LabUse> getLabUseByRoomId(String roomId) {
        return null;
    }

    @Override
    public List<LabUse> getLabUseByUserId(String userId) {
        return null;
    }


    @Override
    public boolean orderRoom(LabUse labUse) {
        return false;
    }
}
