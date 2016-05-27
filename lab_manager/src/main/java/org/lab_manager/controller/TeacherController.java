package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/27.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
    /**
     * 获取老师所有实验
     _tea_lab (post) ok
     params: username(用户名), role(角色)
     [
     {
     "labName": "机器人实验",
     "labId": "0001"
     },
     {
     "labName": "足球实验",
     "labId": "0002"
     },
     {
     "labName": "sex实验",
     "labId": "0003"
     },
     {
     "labName": "禁忌实验",
     "labId": "0004"
     }
     ]
     */
    @ResponseBody
    @RequestMapping(value="/teaAllLab",method = RequestMethod.POST)
    public String teaAllLab(String json) {

        return "hello";
    }

    /**
     * 获取相应实验的学生信息
     _tea_labStuInfo (post) ok
     params: labName(实验名称) labId(实验id) username(用户名) role(角色)
     [
     "sid","mingen","natalie","Airdy", "Bob"
     ]
     */
    @ResponseBody
    @RequestMapping(value="/getExpStuInfo",method = RequestMethod.POST)
    public String getExpStuInfo(String json) {

        return "hello";
    }

    /**
     * 发送学生成绩
     _tea_post_grade (post) ok
     params:
     {
     "stu": [
     {
     "stuName": "sid",
     "stuGrade": "98"
     },
     {
     "stuName": "airdy",
     "stuGrade": "98"
     },
     {
     "stuName": "mingen",
     "stuGrade": "48"
     }
     ],
     "username": "sid",
     "role": "teacher"
     }
     need:
     {
     "status": "0"
     }
     */
    @ResponseBody
    @RequestMapping(value="/uploadStuGrade",method = RequestMethod.POST)
    public String uploadStuGrade(String json) {

        return "hello";
    }
}