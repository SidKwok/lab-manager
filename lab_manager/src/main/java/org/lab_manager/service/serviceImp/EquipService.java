package org.lab_manager.service.serviceImp;

import com.sun.xml.internal.ws.developer.Serialization;
import org.lab_manager.entity.EquipInfo;
import org.lab_manager.service.IEquipService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/26.
 */
@Service
public class EquipService implements IEquipService{
    @Override
    public List<EquipInfo> getAllEquipInfo() {
        return null;
    }

    @Override
    public EquipInfo queryEquipById(String id) {
        return null;
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


}
