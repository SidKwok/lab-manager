package org.lab_manager.dao;

import org.lab_manager.entity.EquipInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by Silence on 2016/5/23.
 */
@Repository
public interface EquipInfoDao {
    public EquipInfo queryById(Integer id);
}
