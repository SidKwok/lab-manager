package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Silence on 2016/5/24.
 */
@Repository
public interface NoticeDao {
    public Notice queryById(Integer id);
    public List<Notice> getAllNotice();
    public boolean addNotice(@Param("content") String content, @Param("author") String author);
}
