package org.lab_manager.dao;

import org.lab_manager.entity.DeviceOrder;

import java.util.List;

/**
 * Created by Silence on 2016/5/26.
 */
public interface DeviceOrderDao {
    /*
    获取所有的设备预定信息
     */
    public List<DeviceOrder> getAllDeviceOrder();
}

