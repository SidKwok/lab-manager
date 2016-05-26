package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.StudentDao;
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

    @Override
    public List<Student> getAllStudent() {
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
}
