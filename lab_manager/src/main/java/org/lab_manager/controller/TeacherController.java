package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/27.
 */

import com.alibaba.fastjson.JSON;
import org.lab_manager.service.ITeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeachService teacherService;

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
    public String teaAllLab(@RequestParam("username")String username,@RequestParam("role")String role) {
        List<Object> result=new ArrayList<Object>();

        for(int i=0;i<3;i++){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("labName","LOL塔下补兵技巧");
            item.put("labId","004");
            result.add(item);
        }
        return JSON.toJSONString(result);
    }

    /**
     * 获取相应实验的学生信息
     _tea_labStuInfo (post) ok		(/teacher/getExpStuInfo)
     params: labName(实验名称) labId(实验id) username(用户名) role(角色)
     [
     {
     "stuId": "0001",
     "stuName": "sid"
     },
     {
     "stuId": "0002",
     "stuName": "mingen"
     },
     {
     "stuId": "0003",
     "stuName": "natalie"
     },
     {
     "stuId": "0004",
     "stuName": "Airdy"
     },
     {
     "stuId": "0005",
     "stuName": "Bob"
     }
     ]
     */
    @ResponseBody
    @RequestMapping(value="/getExpStuInfo",method = RequestMethod.POST)
    public String getExpStuInfo(@RequestParam("username")String username,@RequestParam("role")String role,@RequestParam("labName")String labName,@RequestParam("labId")String labId) {
        System.out.println("收到学生实验信息相关请求");
        List<Object> result=new ArrayList<Object>();
        for(int i=0;i<2;i++){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("stuId","20131003838");
            item.put("stuName","王大傻");
            result.add(item);
        }
        return JSON.toJSONString(result);
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