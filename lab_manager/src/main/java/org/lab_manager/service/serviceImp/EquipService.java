package org.lab_manager.service.serviceImp;

import com.sun.xml.internal.ws.developer.Serialization;
import org.lab_manager.dao.EquipInfoDao;
import org.lab_manager.dao.EquipOrderDao;
import org.lab_manager.entity.EquipInfo;
import org.lab_manager.entity.EquipOrder;
import org.lab_manager.service.IEquipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaofeige on 2016/5/26.
 */
@Service
public class EquipService implements IEquipService{
    @Resource
    private EquipOrderDao equipOrderDao;

    @Resource
    private EquipInfoDao equipInfoDao;

    @Override
    public List<EquipInfo> getAllEquipInfo() {
        return equipInfoDao.getAllAssets();
    }

    @Override
    public EquipInfo queryEquipById(String id) {
        return equipInfoDao.queryById(Integer.parseInt(id));
    }

    @Override
    public boolean updateEquipInfo(EquipInfo equipInfo) {
        return false;
    }

    @Override
    public boolean addEquip(EquipInfo equipInfo) {
        return false;
    }

    @Override
    public boolean deleteEquipById(String id) {

        return false;
    }

    @Override
    public List<EquipOrder> getAllEquipOrder() {
        return equipOrderDao.getAllEquipOrderStatus();
    }

    @Override
    public boolean addEquipOrder(String assetName, Integer number, Integer days, String applicant) {

        return equipOrderDao.orderEquip(assetName,number,days,applicant);
    }

    @Override
    public boolean approveOrderEquip(Integer id) {
        return equipOrderDao.approveEquipOrder(id);
    }

    @Override
    public boolean refuseOrderEquip(Integer id) {
        return equipOrderDao.refuseEquipOrder(id);
    }


}
