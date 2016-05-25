package org.lab_manager.controller;

import com.alibaba.fastjson.JSON;
import org.lab_manager.entity.Student;
import org.lab_manager.service.IStudentService;
import org.lab_manager.service.serviceImp.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/student")
public class StudentController {
//    @Autowired
//    private IStudentService     mStudentService;

    @ResponseBody
    @RequestMapping(value="/addStudent", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student s) {
        //添加学生

        return "hello";
    }

    @ResponseBody
    @RequestMapping(value="/deleteStudent", method = RequestMethod.POST)
    public String deleteStudent(@RequestBody int id) {
        //按学号删除学生，调用service

        return "hello";
    }

    @ResponseBody
    @RequestMapping(value="/queryAllStudent", method = RequestMethod.POST)
    public String queryStudent() {
        //搜索到学生然后放到pw里面去
//        List<Student> list=mStudentService.getAllStudent();
//        List<Map<String,String>> allStudent=new ArrayList<Map<String, String>>();
//        Map<String,String> map=new HashMap<String, String>();
//        for(Student s:list){
//
//        }
//        return JSON.toJSONString(allStudent);

        return JSON.toJSONString("12");
    }

    @ResponseBody
    @RequestMapping(value="/updateStudent", method = RequestMethod.POST)
    public String updateStudent(@RequestBody Student student) {

        return "hello";
    }
}