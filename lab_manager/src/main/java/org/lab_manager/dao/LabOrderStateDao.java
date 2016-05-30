package org.lab_manager.dao;

import org.lab_manager.entity.LabOrderState;

import java.util.List;

/**
 * Created by Silence on 2016/5/27.
 */
public interface LabOrderStateDao {
    //查询实验申请状态
    public List<LabOrderState> getLabOrderState(String user_name);
    //查询设备申请状态
    public List<LabOrderState> getEquipOrderState(String user_name);
}
