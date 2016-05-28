package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.EquipOrder;

import java.util.List;

/**
 * Created by Silence on 2016/5/28.
 */
public interface EquipOrderDao {
    public boolean orderEquip(@Param("assetName") String assetName, @Param("number") Integer number, @Param("days") Integer days, @Param("applicant") String applicant);
    public List<EquipOrder> getAllEquipOrderStatus();
    public boolean approveEquipOrder(Integer id);
    public boolean refuseEquipOrder(Integer id);
}
