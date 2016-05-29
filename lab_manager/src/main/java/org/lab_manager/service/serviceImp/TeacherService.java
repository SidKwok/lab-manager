package org.lab_manager.service.serviceImp;

import org.lab_manager.service.ITeachService;
import org.springframework.stereotype.Service;

/**
 * Created by xiaofeige on 2016/5/29.
 */
@Service
public class TeacherService implements ITeachService {
    @Override
    public boolean uploadStuGrade() {
        return false;
    }

    @Override
    public boolean updateStuAttendence() {
        return false;
    }
}
