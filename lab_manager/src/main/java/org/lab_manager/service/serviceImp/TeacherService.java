package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.ExperimentDao;
import org.lab_manager.dao.ScoreDao;
import org.lab_manager.dao.TeacherDao;
import org.lab_manager.entity.Experiment;
import org.lab_manager.entity.LabOrderState;
import org.lab_manager.entity.Student;
import org.lab_manager.entity.Teacher;
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
    private TeacherDao teacherDao;
    @Autowired
    private ScoreDao  scoreDao;

    @Autowired
    private ExperimentDao experimentDao;

    @Override
    public boolean uploadStuGrade(String stuId,String score,String courseId) {
        try{
            Experiment experiment = experimentDao.queryById(Integer.parseInt(courseId));
            scoreDao.updateScore(stuId,experiment.getCourse_name(),score);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean uploadStuAttendence(String date,String stuId,String course,float score,String present) {
        try{
            teacherDao.insertPresentInfo(date,stuId,course,score,present);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<Experiment> getAllExperiment(String id){
        try{
            return teacherDao.getALLExperiment(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Student> getAllStudent(String id){
        return teacherDao.getAllStudent(id);
    }

    @Override
    public List<LabOrderState> getAllLabOrder(String teacherId) {
        try{
            return teacherDao.getAllLabOrder(teacherId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Teacher getTeacherById(String teacherId) {
        try{
            Teacher teacher = teacherDao.queryById(teacherId);
            return teacher;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
