package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.Notice;

import java.util.List;

/**
 * Created by Silence on 2016/5/24.
 */
public interface NoticeDao {
    public Notice queryById(Integer id);
    public List<Notice> getAllNotice();
    public boolean addNotice(@Param("content") String content, @Param("author") String author);
}
