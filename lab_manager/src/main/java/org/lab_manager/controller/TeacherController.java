package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/27.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.ObjectArraySerializer;
import org.lab_manager.entity.Experiment;
import org.lab_manager.entity.Student;
import org.lab_manager.service.ITeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

        List<Experiment> allExperiments = teacherService.getAllExperiment(username);
        for(Experiment expSingle:allExperiments){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("labName",expSingle.getCourse_name());
            item.put("labId",expSingle.getCourse_id());

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
        List<Student> allStudents = teacherService.getAllStudent(username);
        for(Student stuSingle:allStudents){
            Map<String,Object> item=new HashMap<String, Object>();

            item.put("stuId",stuSingle.getSID());
            item.put("stuName",stuSingle.getSName());
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
    public String uploadStuGrade(@RequestBody String data) {

//        JSONObject list=jsonObject.getObject("stu",JSONObject.class);
//        System.out.println("收到上传的学生信息====="+jsonObject==null);
//        System.out.println(list==null);
////        Map<String,Object>
//        System.out.println(jsonObject.get("stu").getClass());
//        JSONObject jsonObject = JSON.parseObject(data);
//        JSONObject students = jsonObject.getObject("stu", JSONObject.class);
//        String role=jsonObject.getObject("role",String.class);
//        System.out.println(stu+"=========");
//
        System.out.println(data);
        JSON.parseObject(data, new TypeReference<List<Map<String, Object>>>() {
        });

//        System.out.println(jsonFile.get("stu").getClass());
//        System.out.println(jsonFile.get("role"));


//        String role = jsonObject.getObject("role", String.class);
//        System.out.println(role+"=====");


        String flag="0";
        Map<String,Object> result=new HashMap<String, Object>();
        result.put("status",flag);

        return JSON.toJSONString(result);
    }
}