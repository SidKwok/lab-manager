package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.ExperimentDao;
import org.lab_manager.dao.LabCommentDao;
import org.lab_manager.dao.LabInfoDao;
import org.lab_manager.dao.LabUseDao;
import org.lab_manager.entity.*;
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

    @Autowired
    private ExperimentDao experimentDao;

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
        try{
            labCommentDao.addComment(id,comment);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<LabComment> getLabComment(String roomId) {
        return labCommentDao.getAllComment(Integer.parseInt(roomId));
    }

    @Override
    public List<Experiment> getLabUseByRoomId(String roomId) {
        //return null;
        try{
            return experimentDao.getExperimentsByRoomID(roomId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<LabUse> getLabUseByUserId(String userId) {
        return null;
    }

    @Override
    public boolean orderRoom(String roomId,String labName,String applicant,String startTime,String course) {
        try{
            String now="";
            experimentDao.applyExperiment(labName,Integer.parseInt(roomId),applicant,startTime,course,course,course,now);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteLabRoom(Integer roomId){
        try {
            mLabInfoDao.deleteLab(roomId);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
