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
    public boolean updateAsset(@Param("id") Integer id, @Param("asset_name") String asset_name, @Param("class_no") Integer class_no, @Param("class_name") String class_name, @Param("value_type") String value_type, @Param("number") Integer number);
    /*
    添加资产信息
     */
    public boolean addAsset(@Param("asset_name") String asset_name, @Param("class_no") Integer class_no,
                            @Param("class_name") String class_name, @Param("origin_name") String origin_name,
                            @Param("purchase_unit") String purchase_unit, @Param("value_type") String value_type,
                            @Param("unit_price") float unit_price, @Param("number") Integer number,
                            @Param("invoice_num") String invoice_num, @Param("measurement_unit") String measurement_unit,
                            @Param("purchase_date") String purchase_date, @Param("finacial_res") String finacial_res,
                            @Param("asset_res") String asset_res, @Param("handle_person") String handle_person,
                            @Param("charge_type") String charge_type, @Param("check_date") String check_date,
                            @Param("recept_date") String recept_date, @Param("purchase_form") String purchase_form,
                            @Param("manage_part") String manage_part, @Param("subject_type") String subject_type,
                            @Param("subject") String subject, @Param("remark") String remark,
                            @Param("finantial_opinion") String fiantial_opinion, @Param("purchasing_agent") String purchasing_unit,
                            @Param("model") String model, @Param("standard") String standard,
                            @Param("production_date") String production_date, @Param("country") String country,
                            @Param("manufacturer") String manufacture, @Param("brand") String brand,
                            @Param("power") String power, @Param("estimated_expiration_date") String extimated_expiration_date,
                            @Param("durable_yeas") Integer durable_years, @Param("retailer") String retailer);
    /**
     * 测试
     */
    boolean insert(@Param("asset_name") String asset_name, @Param("class_no") Integer class_no, @Param("class_name") String class_name, @Param("value_type") String value_type, @Param("number") Integer number);
}
