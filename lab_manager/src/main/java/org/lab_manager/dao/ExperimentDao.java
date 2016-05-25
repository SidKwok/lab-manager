package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.Experiment;

/**
 * Created by Silence on 2016/5/23.
 */
public interface ExperimentDao {
    public Experiment queryById(String id);
    public Experiment queryByIdAndName(@Param("id") String id,@Param("name") String name);
    public Experiment addExperiment(String courseId,String courseName,String class_name,Integer term,String roomNum,String teacher,String startTime,String endTime);
}
