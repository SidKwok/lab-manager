package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.LabComment;

import java.util.List;

/**
 * Created by Silence on 2016/5/24.
 */
public interface LabCommentDao {
    /*
    根据指定id获取实验评论
     */
    public LabComment getLabComment(Integer id);
    /*
    获取某一实验的所有评论
     */
    public List<LabComment> getAllComment(Integer id);
    /*
    添加实验室评论
     */
    public boolean addComment(@Param("roomId") Integer roomId,@Param("comment") String comment);
}
