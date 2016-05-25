package org.lab_manager.service;

import org.lab_manager.entity.Student;
import org.lab_manager.entity.Teacher;

/**
 * Created by xiaofeige on 2016/5/24.
 */
public interface ILoginService {
    /**
     * 学生登录
     */
    public boolean studentLogin(Student student);

    /**
     * 老师登录
     */
    public boolean teacherLogin(Teacher teacher);


}
