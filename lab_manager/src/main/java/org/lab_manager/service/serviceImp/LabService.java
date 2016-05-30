package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.LabCommentDao;
import org.lab_manager.dao.LabInfoDao;
import org.lab_manager.dao.LabUseDao;
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

    @Autowired
    private LabCommentDao labCommentDao;

    @Autowired
    private LabUseDao labUseDao;

    @Override
    public LabInfo getLabRoomInfo(Integer roomId){
        return mLabInfoDao.getLabInfo(roomId);
    }

    @Override
    public List<LabInfo> getAllLabRoom(){
        return mLabInfoDao.getAllLabInfo();
    }

    @Override
    public boolean addLabRoom(Integer labId,String labName,String teacher,String intro) {
        try {
            mLabInfoDao.addLab(labId,labName,teacher,intro);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateLabRoom(Integer labId,String labName,String teacher,String intro) {
        try {
            mLabInfoDao.updateLab(labId,labName,teacher,intro);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean addComment(Integer id, String comment) {
        labCommentDao.addComment(id,comment);
        return false;
    }

    @Override
    public List<LabComment> getLabComment(String roomId) {
        return labCommentDao.getAllComment(Integer.parseInt(roomId));
    }

    @Override
    public List<LabUse> getLabUseByRoomId(Integer roomId) {
        //return null;
        return labUseDao.getLabUseInfo(roomId);
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
