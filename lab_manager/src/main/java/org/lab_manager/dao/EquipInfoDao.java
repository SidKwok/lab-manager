package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.EquipInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Silence on 2016/5/23.
 */
@Repository
public interface EquipInfoDao {
    /*
    获取指定设备ID的信息
     */
    public EquipInfo queryById(Integer id);
    /*
    获取所有资产
     */
    public List<EquipInfo> getAllAssets();
    /*
    根据资产名字获取资产信息
     */
    public EquipInfo getAssetInfo(String asset_name);
    /*
    删除资产信息
     */
    public boolean deleteAsset(String id);
    /*
    更新资产信息
     */
    public boolean updateAsset(@Param("id")Integer id,@Param("asset_name") String asset_name,@Param("class_no") Integer class_no,@Param("class_name") String class_name,@Param("value_type") String value_type,@Param("number") Integer number);
    /*
    添加资产信息
     */
    public boolean addAsset(@Param("asset_name") String asset_name,@Param("class_no") Integer class_no,@Param("class_name") String class_name,@Param("value_type") String value_type,@Param("number") Integer number);
}
