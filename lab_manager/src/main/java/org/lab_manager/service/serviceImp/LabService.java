package org.lab_manager.service.serviceImp;

import org.lab_manager.entity.LabRoom;
import org.lab_manager.service.ILabService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaofeige on 2016/5/24.
 */
public class LabService implements ILabService {

    public List<LabRoom> getAllLabRoom(){
        List<LabRoom> list=new ArrayList<LabRoom>();
        return list;
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
