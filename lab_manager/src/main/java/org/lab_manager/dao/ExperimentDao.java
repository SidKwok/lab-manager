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
    /*
    获取指定实验信息
     */
    public Experiment queryById(Integer id);

    /**
     *通过实验名模糊搜索实验
     */
    public List<Experiment> getExpByName(String courseName);

    /**
     *通过老师ID查询
     */
    public Experiment getExpByTeacherId(String tID);

    public Experiment queryByIdAndName(@Param("id") String id,@Param("name") String name);
    /*
    添加实验课程
     */
    public boolean addExperiment(@Param("CourseId") String courseId,@Param("courseName")String courseName,@Param("class_name")String class_name,@Param("term")Integer term,@Param("roomNum")String roomNum,String teacher,@Param("startTime")String startTime,@Param("endTime")String endTime);

    /*
    获取所有实验预定状态
     */
    public List<Experiment> queryAllExperimentOrderState();

    /**
     *根据房间号获取此房间的所有实验
     */
    public List<Experiment> getExperimentsByRoomID(String roomID);

    /**
     *根据老师名字获取该老师的所有实验
     */
    public List<Experiment> getExperimentsByTeacherName(String name);

    /*
    预定实验
     */
    public boolean applyExperiment(@Param("courseName") String courseName,@Param("roomId")Integer roomId,@Param("applicant") String applicant,@Param("startTime")String startTime,@Param("endTime")String endTIme,@Param("weekDay")String weekDay,@Param("dayTime")String  dayTime,@Param("order_date")String  orderDate);
    /*
    批准实验预定
     */
    public boolean approveApply(Integer id);
    /*
    拒绝实验预约
     */
    public boolean refuseApply(Integer id);
}
