package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.ScoreDao;
import org.lab_manager.dao.StudentDao;
import org.lab_manager.entity.Score;
import org.lab_manager.entity.Student;
import org.lab_manager.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaofeige on 2016/5/23.
 */
@Service
public class StudentService implements IStudentService{
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ScoreDao scoreDao;

    @Override
    public List<Student> getAllStudent() {
        try{
            return studentDao.queryAllStudent();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteStudent(String Sid) {
        return false;
    }

    @Override
    public boolean addStudent(Student student) {
        return false;
    }

    @Override
    public List<Student> getAttendenceByStuId(String stuId) {
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Score> getStuScore(String stuId) {
        try{
            List<Score> score = scoreDao.getScoreBySNO(stuId);
            return score;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
