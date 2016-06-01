package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.Experiment;
import org.lab_manager.entity.LabOrderState;
import org.lab_manager.entity.Student;
import org.lab_manager.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Silence on 2016/5/24.
 */
@Repository
public interface TeacherDao {
    /**
     * 根据老师ID获取老师该老师所有信息
     */
    public Teacher queryById(String id);
    /**
     * 根据老师ID获取该老师的所有实验
     */
    public List<Experiment> getALLExperiment(String teacherId);
    /**
     * 获取某一个老师某一门课所有学生
     */
    public List<Student> getAllStudent(String courseId);

    /**
     * 根据老师id获取所有的实验室预定
     */
    public List<LabOrderState> getAllLabOrder(String teacherId);


    /**
     * 往考勤表中插入数据
     */
    public boolean insertPresentInfo(@Param("date") String date, @Param("stuId") String stuId, @Param("course") String course, @Param("score") float score, @Param("present") String present);
}
