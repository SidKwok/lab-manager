package org.lab_manager.dao;

import org.lab_manager.entity.DeviceOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Silence on 2016/5/26.
 */
@Repository
public interface DeviceOrderDao {
    public List<DeviceOrder> getAllDeviceOrder();
}
