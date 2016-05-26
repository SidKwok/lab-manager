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
    public boolean studentLogin(Student student){
        return true;
    }


    public boolean teacherLogin(Teacher teacher){
        return true;
    }

    @Override
    public Role login(User user) {
        return null;
    }

    @Override
    public boolean logout(User user) {
        return false;
    }
}
