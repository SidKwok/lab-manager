package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.EquipInfo;

import java.util.List;

/**
 * Created by Silence on 2016/5/23.
 */
public interface EquipInfoDao {
    public EquipInfo queryById(Integer id);
    public List<EquipInfo> getAllAssets();
    public EquipInfo getAssetInfo(String asset_name);
    public boolean deleteAsset(String asset_name);
    public boolean updateAsset(@Param("asset_name") String asset_name, @Param("class_no") Integer class_no, @Param("class_name") String class_name, @Param("value_type") String value_type, @Param("number") Integer number);
    public boolean addAsset(@Param("asset_name") String asset_name, @Param("class_no") Integer class_no, @Param("class_name") String class_name, @Param("value_type") String value_type, @Param("number") Integer number);
}
