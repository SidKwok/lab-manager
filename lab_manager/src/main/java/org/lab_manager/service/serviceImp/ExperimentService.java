package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.ExperimentDao;
import org.lab_manager.entity.Experiment;
import org.lab_manager.service.IExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/23.
 */
@Service
public class ExperimentService implements IExperimentService {
    @Autowired
    ExperimentDao mExpDao;


    @Override
    public Experiment getExperimentById(String eId) {
        return mExpDao.queryById(eId);
    }

    @Override
    public List<Experiment> getAllExp() {
        return mExpDao.queryAllExperimentOrderState();
    }

    @Override
    public boolean addExp(String courseId, String courseName, String class_name, Integer term, String roomNum, String teacher, String startTime, String endTime) {
        return false;
    }

    @Override
    public boolean approveExp(Integer id) {
        return false;
    }

    @Override
    public boolean refuseExp(Integer id) {
        return false;
    }

    @Override
    public boolean applyExp(String courseName, Integer roomId, String applier, String week, String endtime, String weekday, String dayTime) {
        return false;
    }
}
