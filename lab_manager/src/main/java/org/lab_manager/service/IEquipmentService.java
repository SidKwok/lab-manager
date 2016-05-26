package org.lab_manager.service;

import org.lab_manager.entity.EquipmentInfo;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/25.
 */
public interface IEquipmentService {

    /**
     * 获取所有设备
     */
    public List<EquipmentInfo> getAllEquipInfo();

    /**
     * 按ID获取设备信息
     */
    public EquipmentInfo queryEquipById(String id);

    /**
     * 更新设备信息
     */
    public boolean updateEquipInfo(EquipmentInfo equipmentInfo);

    /**
     * 添加设备入库
     */

    public boolean addDevice(EquipmentInfo equipmentInfo);

    /**
     * 删除设备
     */
    public boolean deleteDeviceById(String id);
}
