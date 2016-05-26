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
        return null;
    }
}
