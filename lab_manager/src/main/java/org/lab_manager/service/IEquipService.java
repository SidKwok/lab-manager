package org.lab_manager.service;

import org.lab_manager.entity.EquipInfo;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/25.
 */
public interface IEquipService {

    /**
     * 获取所有设备
     */
    public List<EquipInfo> getAllEquipInfo();

    /**
     * 按ID获取设备信息
     */
    public EquipInfo queryEquipById(String id);

    /**
     * 更新设备信息
     */
    public boolean updateEquipInfo(EquipInfo equipInfo);

    /**
     * 添加设备入库
     */

    public boolean addEquip(EquipInfo equipInfo);

    /**
     * 删除设备
     */
    public boolean deleteEquipById(String id);
}
