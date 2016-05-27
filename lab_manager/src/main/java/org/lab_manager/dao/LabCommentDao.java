package org.lab_manager.dao;

import org.lab_manager.entity.LabComment;
import org.springframework.stereotype.Repository;

/**
 * Created by Silence on 2016/5/24.
 */
@Repository
public interface LabCommentDao {
    public LabComment getLabComment(Integer id);
}
