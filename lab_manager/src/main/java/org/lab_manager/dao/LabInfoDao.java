package org.lab_manager.dao;

import org.lab_manager.entity.LabInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Silence on 2016/5/23.
 */
@Repository
public interface LabInfoDao {
    public LabInfo queryById(Integer id);
    public List<LabInfo> getAllLabInfo();
}
