package org.lab_manager.dao;

import org.lab_manager.entity.Announcement;

/**
 * Created by Silence on 2016/5/24.
 */
public interface AnnouncementDao {
    public Announcement queryById(Integer id);
<<<<<<< HEAD
    public Announcement insert(Integer id,String date,String content,String author);
=======
    public Announcement insert(Integer id, String date, String content, String author);
>>>>>>> fb146a3dacd11589875e1dbd9ab19d461d5e056b
}
