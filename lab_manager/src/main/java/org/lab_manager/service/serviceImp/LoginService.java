package org.lab_manager.service.serviceImp;

import org.lab_manager.entity.Role;
import org.lab_manager.entity.Student;
import org.lab_manager.entity.Teacher;
import org.lab_manager.entity.User;
import org.lab_manager.service.ILoginService;
import org.springframework.stereotype.Service;

/**
 * Created by xiaofeige on 2016/5/24.
 */
@Service
public class LoginService implements ILoginService {

    @Override
    public Role login(String username,String password) {

        return null;
    }

    @Override
    public boolean logout(User user) {
        return false;
    }
}
