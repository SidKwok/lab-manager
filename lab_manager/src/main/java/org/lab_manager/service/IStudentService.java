package org.lab_manager.service;

import org.lab_manager.entity.Attendence;
import org.lab_manager.entity.Score;
import org.lab_manager.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaofeige on 2016/5/19.
 */
public interface IStudentService {
    /**
     *获取所有学生
     */
    public List<Student> getAllStudent();

    /**
     * 按学号删除学生
     */
    public boolean deleteStudent(String Sid);

    /**
     * 添加学生
     */
    public boolean addStudent(Student student);

    /**
     * 获取一个学生的所有考勤情况
     */
    public List<Attendence>    getAttendenceByStuId(String stuId);

    /**
     * 查询学生的所有课程成绩
     */
    public List<Score>  getStuScore(String stuId);
}
