package org.lab_manager.dao;

import org.lab_manager.entity.DeviceInfo;

/**
 * Created by Silence on 2016/5/23.
 */
public interface DeviceInfoDao {
    public DeviceInfo queryById(Integer id);
}
