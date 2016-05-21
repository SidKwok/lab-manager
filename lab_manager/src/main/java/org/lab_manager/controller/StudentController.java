package org.lab_manager.controller;

import org.lab_manager.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;


@Controller
@RequestMapping("/student")
public class StudentController {

    @ResponseBody
    @RequestMapping(value="/addStudent", method = RequestMethod.POST)
    public String addStudent(Student s) {
        //添加学生

        return "hello";
    }

    @ResponseBody
    @RequestMapping(value="/deleteStudent", method = RequestMethod.POST)
    public String deleteStudent(String sId) {
        //按学号删除学生，调用service

        return "hello";
    }

    @ResponseBody
    @RequestMapping(value="/queryAllStudent", method = RequestMethod.POST)
    public void queryStudent(PrintWriter pw) {
        //搜索到学生然后放到pw里面去

    }

    @ResponseBody
    @RequestMapping(value="/updateStudent", method = RequestMethod.POST)
    public String updateStudent(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }
}