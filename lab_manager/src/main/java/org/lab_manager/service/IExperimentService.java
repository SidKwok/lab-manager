package org.lab_manager.service;

import org.lab_manager.entity.Experiment;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/23.
 */
public interface IExperimentService {
    /**
     * 按编号查询获取实验信息
     *
     */
    public Experiment getExperimentById(String eId);

    /**
     * 按实验名称搜索实验
     */
    public List<Experiment> getExperimentByName(String name);
    /**
     * 查询所有实验的状态
     */
    public List<Experiment> getAllExp();

    /**
     * 增加实验
     */
    public boolean addExp(String courseId,String courseName, String class_name,Integer term,String roomNum, String teacher,String startTime, String endTime);

    /**
     * 同意实验申请
     */
    public boolean approveExp(Integer id);

    /**
     * 拒绝实验申请
     */
    public boolean refuseExp(Integer id);

    /**
     * 申请实验
     */
    public boolean applyExp(String courseName,Integer roomId,String applier,String week,String endtime,String weekday,String dayTime);
}
