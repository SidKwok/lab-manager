package org.lab_manager.service;

import org.lab_manager.entity.LabRoom;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/24.
 */
public interface ILabService {
    /**
     * 获取所有实验室信息
     */
    public List<LabRoom> getAllLabRoom();

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
    public boolean addComment(String roomId,String comment);

    /**
     *
     */
}
