package org.lab_manager.dao;

import org.lab_manager.entity.Attendence;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Silence on 2016/5/31.
 */
@Repository
public interface AttendenceDao {
    /**
     * 获取所有的签到情况
     */
    public List<Attendence> getAllAttendence();
    /**
     * 通过学生ID获取签到情况
     */
    public List<Attendence> getAttendenceById(String SID);
}
