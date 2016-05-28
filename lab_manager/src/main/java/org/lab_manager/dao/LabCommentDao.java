package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.LabComment;

import java.util.List;

/**
 * Created by Silence on 2016/5/24.
 */
public interface LabCommentDao {
    public LabComment getLabComment(Integer id);
    public List<LabComment> getAllComment(Integer id);
    public boolean addComment(@Param("roomId") Integer roomId, @Param("comment") String comment);
}
