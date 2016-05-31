package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.UserDao;
import org.lab_manager.entity.Role;
import org.lab_manager.entity.Student;
import org.lab_manager.entity.Teacher;
import org.lab_manager.entity.User;
import org.lab_manager.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaofeige on 2016/5/24.
 */
@Service
public class LoginService implements ILoginService {
    @Autowired
    private UserDao userDao;

    @Override
    public Role login(String username,String password) {
        try{
            String userRoleId=userDao.getRoleId(username,password);
            if(userRoleId!=null){
                return userDao.getRole(userRoleId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean logout(String username) {
        //移除当前session
        return false;
    }
}
