package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.plugin.Interceptor;
import org.lab_manager.entity.LabInfo;

import java.util.List;

/**
 * Created by Silence on 2016/5/23.
 */
public interface LabInfoDao {
    //根据实验室名称查询对应实验室具体信息
    public LabInfo getLabInfo(Integer id);
    //获取多有实验室的信息
    public List<LabInfo> getAllLabInfo();
    //根据实验室名称删除对应的实验室所有信息
    public boolean deleteLab(String labName);
    //更新实验室信息
    public boolean updateLab(@Param("labId")Integer labId,@Param("labName") String labName,@Param("teacher") String teacher,@Param("intro") String intro);
    //添加新的实验室
    public boolean addLab(@Param("labId")Integer labId, @Param("labName") String labName, @Param("teacher") String teacher, @Param("intro") String intro);
}
