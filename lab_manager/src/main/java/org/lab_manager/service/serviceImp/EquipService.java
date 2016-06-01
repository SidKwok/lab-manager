package org.lab_manager.service.serviceImp;

import com.sun.xml.internal.ws.developer.Serialization;
import org.lab_manager.dao.EquipInfoDao;
import org.lab_manager.dao.EquipOrderDao;
import org.lab_manager.entity.EquipInfo;
import org.lab_manager.entity.EquipOrder;
import org.lab_manager.service.IEquipService;
import org.lab_manager.utils.DateTimeUtil;
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
    public boolean updateEquipInfo(Integer id,String asset_name,Integer class_no,String class_name,String value_type,Integer number) {
        try {
            equipInfoDao.updateAsset(id,asset_name,class_no,class_name,value_type,number);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean addEquip(String asset_name,Integer class_no,String class_name,String value_type,Integer number) {
        try {
            equipInfoDao.addAsset(asset_name,class_no,class_name,value_type,number);
        }catch (Exception e){
            return  false;
        }
        return true;
    }

    @Override
    public boolean deleteEquipById(String id) {
        try {
            equipInfoDao.deleteAsset(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<EquipOrder> getAllEquipOrder() {
        return equipOrderDao.getAllEquipOrderStatus();
    }

    @Override
    public boolean addEquipOrder(String assetName,Integer number,String startTime,String endTime,String applicant) {
        try{
            String now= DateTimeUtil.currentTimestamp().toString();
            equipOrderDao.orderEquip(assetName,number,startTime,endTime,applicant,now,"待定");
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean approveOrderEquip(Integer id) {
        return equipOrderDao.approveEquipOrder(id);
    }

    @Override
    public boolean refuseOrderEquip(Integer id) {
        return equipOrderDao.refuseEquipOrder(id);
    }

    @Override
    public List<EquipOrder> getEquipOrderByTeacherId(String teacherId) {
        try{
            return equipOrderDao.getTeacherEquipOrder(teacherId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
