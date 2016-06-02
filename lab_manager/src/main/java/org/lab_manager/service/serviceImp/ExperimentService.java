package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.ExperimentDao;
import org.lab_manager.dao.LabOrderStateDao;
import org.lab_manager.dao.TeacherDao;
import org.lab_manager.entity.Experiment;
import org.lab_manager.entity.Teacher;
import org.lab_manager.entity.User;
import org.lab_manager.service.IExperimentService;
import org.lab_manager.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaofeige on 2016/5/23.
 */
@Service
public class ExperimentService implements IExperimentService {
    @Autowired
    private ExperimentDao mExpDao;

    @Autowired
    private LabOrderStateDao labOrderStateDao;

    @Autowired
    private TeacherDao teacherDao;


    @Override
    public Experiment getExperimentById(String eId) {
        return mExpDao.queryById(Integer.parseInt(eId));
    }

    @Override
    public List<Experiment> getExperimentByName(String name) {
        try{
            return mExpDao.getExpByName("%"+name+"%");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Experiment> getExperimentByTeaName(String teacherName) {
        try{
            List<User> allTeachers = teacherDao.getAllTeacherByName("%" + teacherName + "%");
            List<Experiment> result=new ArrayList<Experiment>();
            for(User tea:allTeachers){
                Experiment e=mExpDao.getExpByTeacherId(tea.getUser_id());
                result.add(e);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
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
        try{
            mExpDao.approveApply(id);

//            labOrderStateDao
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean refuseExp(Integer id) {
        try{
            mExpDao.refuseApply(id);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean applyExp(String courseName, Integer roomId, String applier, String startTime, String endtime, String weekday, String dayTime) {
        try{
            String now= DateTimeUtil.currentTimestamp().toString();
            mExpDao.applyExperiment(courseName,roomId,applier,startTime,endtime,weekday,dayTime,now);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
