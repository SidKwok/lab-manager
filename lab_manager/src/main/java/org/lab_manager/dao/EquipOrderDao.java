package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.EquipOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Silence on 2016/5/28.
 */
@Repository
public interface EquipOrderDao {
    /*
    预定设备
     */
    public boolean orderEquip(@Param("deviceName") String deviceName, @Param("number") Integer number, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("applicant") String applicant, @Param("orderDate") String orderDate, @Param("deviceState") String deviceState);
    /*
    获取所有设备的预定状态
     */
    public List<EquipOrder> getAllEquipOrderStatus();
    /*
    批准设备预约
     */
    public boolean approveEquipOrder(Integer id);
    /*
    拒绝设备预约
     */
    public boolean refuseEquipOrder(Integer id);

    /**
     * 获取指定老师的设备预约状态
     */
    public List<EquipOrder> getTeacherEquipOrder(String teacherId);
}
