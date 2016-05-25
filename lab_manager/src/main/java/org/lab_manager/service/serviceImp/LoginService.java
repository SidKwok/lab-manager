package org.lab_manager.service.serviceImp;

import org.lab_manager.entity.Student;
import org.lab_manager.entity.Teacher;
import org.lab_manager.service.ILoginService;

/**
 * Created by xiaofeige on 2016/5/24.
 */
public class LoginService implements ILoginService {
    public boolean studentLogin(Student student){
        return true;
    }


    public boolean teacherLogin(Teacher teacher){
        return true;
    }
}
