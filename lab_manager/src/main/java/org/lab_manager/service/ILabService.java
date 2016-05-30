package org.lab_manager.service;

import org.lab_manager.entity.LabComment;
import org.lab_manager.entity.LabInfo;
import org.lab_manager.entity.LabRoom;
import org.lab_manager.entity.LabUse;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/24.
 */
public interface ILabService {
    /**
     * 根据房间号获取实验室的所有信息
     */
    public LabInfo getLabRoomInfo(Integer roomId);
    /**
     * 获取所有实验室信息
     */
    public List<LabInfo> getAllLabRoom();

    /**
     * 新增实验室
     */
    public boolean addLabRoom(LabRoom labRoom);


    /**
     * 修改实验室
     */
    public boolean updateLabRoom(LabRoom labRoom);

    /**
     * 为实验室增加评论
     */
    public boolean addComment(Integer id,String comment);

    /**
     * 获取指定实验室评论
     */
    public List<LabComment> getLabComment(String roomId);

    /**
     * 通过房间号获取房间预约情况
     */
    public List<LabUse> getLabUseByRoomId(Integer roomId);

    /**
     * 通过用户id获取房间预约情况
     */
    public List<LabUse> getLabUseByUserId(String userId);

    /**
     * 预约实验室
     */
    public boolean orderRoom(LabUse labUse);


}
