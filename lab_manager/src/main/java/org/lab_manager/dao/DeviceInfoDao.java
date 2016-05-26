package org.lab_manager.dao;

import org.lab_manager.entity.EquipmentInfo;

/**
 * Created by Silence on 2016/5/23.
 */
public interface DeviceInfoDao {
    public EquipmentInfo queryById(Integer id);
}
