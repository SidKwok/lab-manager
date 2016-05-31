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
    /**
    获取指定ID的公告
     */
    public Notice queryById(Integer id);

    /**
    获取所有公告
     */
    public List<Notice> getAllNotice();

    /**
    添加公告
     */
    public boolean addNotice(@Param("date") String date,@Param("content") String content,@Param("author") String author);
}
