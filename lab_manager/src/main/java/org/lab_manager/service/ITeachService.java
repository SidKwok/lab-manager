package org.lab_manager.service;

import org.springframework.stereotype.Repository;

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
     * 
     */
}
