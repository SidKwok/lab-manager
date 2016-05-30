package org.lab_manager.service;

import org.lab_manager.entity.Experiment;
import org.lab_manager.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/27.
 */
@Repository
public interface ITeachService {
    /**
     * 上传学生成绩
     */
    public boolean uploadStuGrade();

    /**
     * 更新学生考勤
     */
    public boolean updateStuAttendence();

    /**
     * 获取老师所有实验项目
     */
    public List<Experiment> getAllExperiment(String id);
    /**
     * 获得该老师所教课程的所有学生
     */
    public List<Student> getAllStudent(String id);
}
