package org.lab_manager.service;

import org.lab_manager.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/25.
 */
@Repository
public interface INoticeService {

    /**
     * 获取所有公告
     */
    public List<Notice> queryAllNotice();

    /**
     * 增加公告
     */
    public boolean addNotice(String author,String content);

    /**
     * 删除公告
     */
    public boolean deleteNoticeById(String id);

    /**
     * 修改公告
     */
    public boolean updateNotice(Notice notice);
}
