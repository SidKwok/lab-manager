package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.Experiment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Silence on 2016/5/23.
 */
@Repository
public interface ExperimentDao {
    public Experiment queryById(String id);
    public Experiment queryByIdAndName(@Param("id") String id, @Param("name") String name);
    public boolean addExperiment(@Param("CourseId") String courseId, @Param("courseName") String courseName, @Param("class_name") String class_name, @Param("term") Integer term, @Param("roomNum") String roomNum, String teacher, @Param("startTime") String startTime, @Param("endTime") String endTime);
    public List<Experiment> queryAllExperimentOrderState();
    public boolean applyExperiment(@Param("courseName") String courseName, @Param("roomId") Integer roomId, @Param("applicant") String applicant, @Param("startTime") String week, @Param("endTime") String endTIme, @Param("weekDay") String weekDay, @Param("dayTime") String dayTime);
    public boolean approveApply(Integer id);
    public boolean refuseApply(Integer id);
}
