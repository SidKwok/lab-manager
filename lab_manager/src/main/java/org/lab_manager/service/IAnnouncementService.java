package org.lab_manager.service;

import org.lab_manager.entity.Announcement;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/25.
 */
public interface IAnnouncementService {

    /**
     * 获取所有公告
     */
    public List<Announcement> queryAllAnnouncement();

    /**
     * 增加公告
     */
    public boolean addAnnouncement(Announcement announcement);

    /**
     * 删除公告
     */
    public boolean deleteAnnouncementById(String id);

    /**
     * 修改公告
     */
    public boolean updateAnnouncement(Announcement announcement);
}
