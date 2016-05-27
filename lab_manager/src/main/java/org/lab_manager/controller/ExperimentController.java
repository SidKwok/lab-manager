package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/27.
 */

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/experiment")
public class ExperimentController {
    /**
     * // 某人的预约状态
     _lab_orderState (post) ok
     params: role(角色), username(用户名)
     {
     "lab":[
     {
     "labName": "机器人实验",
     "labWeek": "第一周",
     "labWeekday": "周五",
     "labCourse": "第1、2节",
     "labOrderId": "0001",
     "labOrderDate": "2016-5-21" ,
     "state": "允许"
     },
     {
     "labName": "足球实验",
     "labWeek": "第二周",
     "labWeekday": "周四",
     "labCourse": "第3、4节",
     "labOrderId": "0002",
     "labOrderDate": "2016-5-24" ,
     "state": "拒绝"
     }
     ],
     "equip":[
     {
     "equipName": "西瓜刀",
     "equipDate": "2015-9-10",
     "equipOrderId": "001",
     "equipDays": "10",
     "equipNumber": "2",
     "state": "未决定"
     },
     {
     "equipName": "狼牙棒",
     "equipDate": "2015-11-10",
     "equipOrderId": "002",
     "equipDays": "2",
     "equipNumber": "10",
     "state": "未决定"
     }
     ]
     }
     */
    @ResponseBody
    @RequestMapping(value="/teacherOrderStatus",method = RequestMethod.POST)
    public String getOrdersOfTeacher(String json){
        List<Map<String,Object>> result=new ArrayList<Map<String, Object>>();

        return JSON.toJSONString(result);
    }

    /**
     * 获取实验课程信息
     _tea_allCourse (post) ok
     params: username(用户名) role(角色)
     [
     {
     "courseId": "0001",
     "labName": "机器人实验",
     "labWeek": "第一周",
     "labWeekday": "周一",
     "labCourse": "第1、2节"
     },
     {
     "courseId": "0002",
     "labName": "足球实验",
     "labWeek": "第二周",
     "labWeekday": "周二",
     "labCourse": "第3、4节"
     },
     {
     "courseId": "0003",
     "labName": "sex实验",
     "labWeek": "第三周",
     "labWeekday": "周三",
     "labCourse": "第5、6节"
     }
     ]
     */
    @ResponseBody
    @RequestMapping(value="/teaAllCourse",method = RequestMethod.POST)
    public String getTeaAllCourse(String json){
        List<Map<String,Object>> result=new ArrayList<Map<String, Object>>();

        return JSON.toJSONString(result);
    }

    /**
     * 获取实验课程的学生信息
     _course_duty (post) ok
     params: username(用户名), role(角色), courseId(实验课程id)
     [
     "sid","mingen","natalie","Airdy"
     ]
     */
    @ResponseBody
    @RequestMapping(value="/courseStuInfo",method = RequestMethod.POST)
    public String gcourseStuInfo(String json){
        List<Map<String,Object>> result=new ArrayList<Map<String, Object>>();

        return JSON.toJSONString(result);
    }

    /**
     * 发送学生考勤状况
     _tea_post_duty (post) ok
     params:
     {
     "stu": [
     {
     "stuName": "sid",
     "stuGrade": "98",
     "stuState": "已到"
     },
     {
     "stuName": "airdy",
     "stuGrade": "98",
     "stuState": "已到"
     },
     {
     "stuName": "mingen",
     "stuGrade": "48",
     "stuState": "未到"
     }
     ],
     "username": "sid",
     "role": "teacher",
     "courseId": "0001"
     }
     need:
     {
     "status": "0"
     }
     */
    @ResponseBody
    @RequestMapping(value="/uploacAttendence",method = RequestMethod.POST)
    public String uploadAttendence(String json){
        List<Map<String,Object>> result=new ArrayList<Map<String, Object>>();

        return JSON.toJSONString(result);
    }


}