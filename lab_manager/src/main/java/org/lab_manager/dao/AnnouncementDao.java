package org.lab_manager.dao;

import org.lab_manager.entity.Announcement;

/**
 * Created by Silence on 2016/5/24.
 */
public interface AnnouncementDao {
    public Announcement queryById(Integer id);

    public Announcement insert(Integer id, String date, String content, String author);
}
