package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/27.
 */

import com.alibaba.fastjson.JSON;
import org.lab_manager.entity.EquipOrder;
import org.lab_manager.entity.Experiment;
import org.lab_manager.entity.LabOrderState;
import org.lab_manager.entity.Student;
import org.lab_manager.service.IEquipService;
import org.lab_manager.service.IExperimentService;
import org.lab_manager.service.ITeachService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/experiment")
public class ExperimentController {
    @Resource
    private ITeachService  teachService;

    @Resource
    private IExperimentService experimentService;

    @Resource
    private IEquipService equipService;

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
    public String getOrdersOfTeacher(@RequestParam("role")String role,@RequestParam("username")String username){
        Map<String,Object> result=new HashMap<String, Object>();
        List<Object> labList=new ArrayList<Object>();
        List<LabOrderState> allLabOrder = teachService.getAllLabOrder(username);
        for(LabOrderState singleOrder:allLabOrder){
            Map<String,Object> labItem=new HashMap<String, Object>();
            labItem.put("labName",singleOrder.getCourse_name());
            labItem.put("labWeek",singleOrder.getStart_time());
            labItem.put("labWeekday",singleOrder.getWeek_day());
            labItem.put("labCourse",singleOrder.getDay_time());
            labItem.put("labOrderId",singleOrder.getCourse_name());
            labItem.put("labOrderDate",singleOrder.getOrder_date());
            labItem.put("state",singleOrder.getState());
            labList.add(labItem);
        }

        List<Object> equipList=new ArrayList<Object>();
        List<EquipOrder> equipOrders = equipService.getEquipOrderByTeacherId(username);
        for(EquipOrder singleEquipOrder:equipOrders){
            Map<String,Object> equipItem=new HashMap<String, Object>();
            equipItem.put("equipName",singleEquipOrder.getDevice_name());
            equipItem.put("equipDate",singleEquipOrder.getOrder_date());
            equipItem.put("equipOrderId","001");
            equipItem.put("equipDays","1");
            equipItem.put("equipNumber","1");
            equipItem.put("state","拒绝");
            equipList.add(equipItem);
        }
        result.put("lab",labList);
        result.put("equip",equipList);
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
    public String getTeaAllCourse(@RequestParam("role")String role,@RequestParam("username")String username){
        List<Object> result=new ArrayList<Object>();
        List<Experiment> exps=teachService.getAllExperiment(username);
        for(Experiment expSingle:exps){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("courseId",expSingle.getCourse_id());
            item.put("labName",expSingle.getCourse_name());
            item.put("labWeek",expSingle.getStart_time());
            item.put("labWeekday",expSingle.getWeek());
            item.put("labCourse",expSingle.getDay_time());
            result.add(item);
        }

        return JSON.toJSONString(result);
    }

    /**
     * 获取实验课程的学生信息
     _course_duty (post) ok			(/experiment/courseStuInfo)
     params: username(用户名), role(角色), courseId(实验课程id)
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
     }
     ]
     */
    @ResponseBody
    @RequestMapping(value="/courseStuInfo",method = RequestMethod.POST)
    public String getcourseStuInfo(@RequestParam("role")String role,@RequestParam("username")String username,@RequestParam("courseId")String courseId){
        List<Object> result=new ArrayList<Object>();
        List<Student> allStudents = teachService.getAllStudent(username);
        for(Student stuSingle:allStudents){
            Map<String,Object> item=new HashMap<String, Object>();

            item.put("stuId", stuSingle.getSID());
            item.put("stuName",stuSingle.getSName());
            result.add(item);
        }
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
    @RequestMapping(value="/uploadAttendence",method = RequestMethod.POST)
    public String uploadAttendence(@RequestParam Map<String,Object> json){
        System.out.println(json.get("username")+"-----------------");

        Map<String,Object> result=new HashMap<String, Object>();

        int flag=0;
//        if(teachService.)
        result.put("status",flag);

        return JSON.toJSONString(result);
    }

    /**
     * 预约实验
     * params: assetName, number, days, applicant
     {
     "status": "0"
     }
     * */
    @ResponseBody
    @RequestMapping(value="/orderExp",method = RequestMethod.POST)
    public String addLabOrder(@RequestParam("assetName")String assetName,@RequestParam("number")int number,@RequestParam("days")int days,@RequestParam("applicant")String applyer) {
        //根据上面的json格式要求返回数据，需查询数据库
        Map<String,Object> result=new HashMap<String, Object>();

        int flag=0;
//        if(experimentService.applyExp())
        result.put("status",flag);
        return JSON.toJSONString(result);
    }
}