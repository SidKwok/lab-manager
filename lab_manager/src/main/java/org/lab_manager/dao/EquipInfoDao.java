package org.lab_manager.dao;

import org.lab_manager.entity.EquipInfo;

import java.util.List;

/**
 * Created by Silence on 2016/5/23.
 */
public interface EquipInfoDao {
    public EquipInfo queryById(Integer id);
    public List<EquipInfo> getAllAssets();
    public EquipInfo getAssetInfo(String asset_name);
}
