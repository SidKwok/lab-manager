package org.lab_manager.service;

import org.lab_manager.entity.EquipInfo;
import org.lab_manager.entity.EquipOrder;

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
    public boolean updateEquipInfo(Integer id,String asset_name,Integer class_no,String class_name,String value_type,Integer number);

    /**
     * 添加设备入库
     */
    public boolean addEquip(String asset_name,Integer class_no,String class_name,String value_type,Integer number);

    /**
     * 删除设备
     */
    public boolean deleteEquipById(String id);

    /**
     * 获取所有设备预约状态
     */
    public List<EquipOrder> getAllEquipOrder();

    /**
     * 添加设备预约
     */
    public boolean addEquipOrder(String assetName,Integer number,Integer days,String applicant);

    /**
     * 同意设备预定
     */
    public boolean approveOrderEquip(Integer id);


    /**
     * 拒绝设备预定
     */
    public boolean refuseOrderEquip(Integer id);

    /**
     * 获取某人预约的设备的状态
     */
    public List<EquipOrder> getEquipOrderByTeacherId(String teacherId);
}
