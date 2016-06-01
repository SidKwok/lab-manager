package org.lab_manager.service;

import org.lab_manager.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/27.
 */
public interface ITeachService {
    /**
     * 上传学生成绩
     */
    public boolean uploadStuGrade(String stuId,String score,String courseName);

    /**
     * 上传学生考勤
     */
    public boolean uploadStuAttendence(String date,String stuId,String course,float score,String present);

    /**
     * 获取老师所有实验项目
     */
    public List<Experiment> getAllExperiment(String id);
    /**
     * 获得该老师所教课程的所有学生
     */
    public List<Student> getAllStudent(String id);

    /**
     * 获取老师之前所有的实验室预定信息
     */
    public List<LabOrderState>  getAllLabOrder(String teacherId);

    /**
     * 根据ID获取老师名
     */
    public User getTeacherById(String teacherId);
}
