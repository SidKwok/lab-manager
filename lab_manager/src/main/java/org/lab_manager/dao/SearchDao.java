package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.Search;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Silence on 2016/5/28.
 */
@Repository
public interface SearchDao {
    //根据老师或者实验名称查找
    public List<Search> searchByTeacherOrExperiment(@Param("item") String item, @Param("type") String type);
}
