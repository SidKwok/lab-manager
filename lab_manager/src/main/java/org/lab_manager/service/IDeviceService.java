package org.lab_manager.service;

import org.lab_manager.entity.DeviceInfo;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/25.
 */
public interface IDeviceService {

    /**
     * 获取所有设备
     */
    public List<DeviceInfo> getAllDeviceInfo();

    /**
     * 按ID获取设备信息
     */
    public DeviceInfo queryDeviceById(String id);

    /**
     * 更新设备信息
     */
    public boolean updateDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 添加设备入库
     */

    public boolean addDevice(DeviceInfo deviceInfo);

    /**
     * 删除设备
     */
    public boolean deleteDeviceById(String id);
}
