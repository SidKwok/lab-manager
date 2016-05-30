package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.TeacherDao;
import org.lab_manager.entity.Experiment;
import org.lab_manager.service.ITeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/29.
 */
@Service
public class TeacherService implements ITeachService {
    @Autowired
    TeacherDao teacherDao;
    @Override
    public boolean uploadStuGrade() {
        return false;
    }

    @Override
    public boolean updateStuAttendence() {
        return false;
    }

    @Override
    public List<Experiment> getAllExperiment(String id){
        return teacherDao.getALLExperiment(id);
    }
}
