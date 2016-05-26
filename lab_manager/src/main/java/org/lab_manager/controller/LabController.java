package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/19.
 */
import com.alibaba.fastjson.JSON;
import org.lab_manager.entity.LabInfo;
import org.lab_manager.entity.LabRoom;
import org.lab_manager.service.ILabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/lab")
public class LabController {
    @Resource
    private ILabService labService;

    /**
    * 预约实验
    * */
    @ResponseBody
    @RequestMapping(value="/orderLab",method = RequestMethod.POST)
    public String addLab() {
        System.out.println("ajax响应");
        return "ajax 调用成功";
    }

    /**
    * 获取实验室预约情况
    params: none
    [
    {
        "labOrderId": "0001",
            "labOrderName": "机器人实验",
            "labOrderDate": "2016-5-21",
            "labOrderWeek": "第一周",
            "labOrderWeekday": "周五",
            "labOrderCourse": "第1、2节",
            "labOrderApplicant": "sid"
    },
    {
        "labOrderId": "0002",
            "labOrderName": "足球实验",
            "labOrderDate": "2016-5-21",
            "labOrderWeek": "第二周",
            "labOrderWeekday": "周四",
            "labOrderCourse": "第5、6节",
            "labOrderApplicant": "mingen"
    }
    ]
    **/
    @ResponseBody
    @RequestMapping(value="/_labOrder_ajax",method = RequestMethod.GET)
    public String getLabUseInfo() {
        //根据上面的json格式要求返回数据，需查询数据库
        System.out.println("ajax响应");
        return "ajax 调用成功";
    }

    /**
    * 批准实验室预约
        _confirm_labOrder (post)
        params: labOrderId
            {
            "status": "0"
            }
    * */
    @ResponseBody
    @RequestMapping(value="/_confirm_labOrder",method = RequestMethod.POST)
    public String confirmOrder() {
        //根据上面的json格式要求返回数据，需查询数据库
        System.out.println("ajax响应");
        return "ajax 调用成功";
    }


    /**
    * 批准实验室预约
       _refuse_labOrder (post)
        params: labOrderId
        {
            "status": "0"
        }
    * */
    @ResponseBody
    @RequestMapping(value="/_refuse_labOrder",method = RequestMethod.POST)
    public String refuseOrder() {
        //根据上面的json格式要求返回数据，需查询数据库
        System.out.println("ajax响应");
        return "ajax 调用成功";
    }

    /**
    *获取所有房间信息
     * params: none
     [
     {
     "room_id": "0001",
     "manage_teacher": "sid",
     "intro": "good"
     },
     {
     "room_id": "0002",
     "manage_teacher": "mingen",
     "intro": "bad"
     }
     ]
    */
    @ResponseBody
    @RequestMapping(value="/queryAllRoom",method = RequestMethod.GET)
    public String getRooms(){
        List<LabInfo> list=labService.getAllLabRoom();
        Map<String,Object> roomSingle=new HashMap<String, Object>();

        List<Map<String,Object>> resultList=new ArrayList<Map<String, Object>>();
        for(LabInfo lab:list){
            roomSingle.put("room_id",lab.getID());
            roomSingle.put("manage_teacher",lab.getManage_teacher());
            roomSingle.put("intro",lab.getIntro());
            resultList.add(roomSingle);
            roomSingle.clear();
        }
        List<LabRoom> rooms=new ArrayList<LabRoom>();

        return JSON.toJSONString(resultList);
//        return "hello";
    }

    /**
    * 通过id获取房间评论
     * params: roomId
     {
     "comment": [
     "good",
     "not bad"
     ]
     }
    */
    @ResponseBody
    @RequestMapping(value="/getRoomComment",method = RequestMethod.POST)
    public String getRoomComment(int roomId){
        //从数据库中获取对应ID的实验室的评论信息

        return "添加评论成功";
    }

    /**
    *给房间添加评论
     * params: roomId, comment
     {
     "status": "0"
     }
    */
    @ResponseBody
    @RequestMapping(value="/addRoomComment",method = RequestMethod.POST)
    public String addRoomComment(String comment){
        //将获得的数据保存到数据库中

        return "添加评论成功";
    }

    /**
    *获取所有房间使用情况
     * params: roomId
     [
     {
     "labName": "fuck",
     "applicant": "sid",
     "week": "第十周",
     "weekday": "周一",
     "course": "1、2节"
     },
     {
     "labName": "sex",
     "applicant": "mingen",
     "week": "第十一周",
     "weekday": "周二",
     "course": "3、4节"
     }
     ]
    */
    @ResponseBody
    @RequestMapping(value="/getRoomOrderInfo",method = RequestMethod.POST)
    public String getRoomStatus(int roomId){
        //将获得的数据保存到数据库中

        return "添加评论成功";
    }

    /**
    *预定实验室房间
     * params: roomId, labName, applicant, week, weekday, course
     {
     "status": "0"
     }
    */
    @ResponseBody
    @RequestMapping(value="/orderRoom",method = RequestMethod.POST)
    public String orderRoom(String jsonFile){
        //从json文件中解析数据，预定房间

        return "1";//这里返回 json "status": "0",其中0 表示预约成功
    }

    /**
    *实验室当前使用信息查询
     * params: item, type (item是内容 type是类型 有教室和实验名)
     {
     "status": "1",
     "result":[
     {
     "teacher": "sid",
     "labName": "fuck",
     "roomId": "001"
     },
     {
     "teacher": "mingen",
     "labName": "sex",
     "roomId": "002"
     }
     ]
     }
    */
    @ResponseBody
    @RequestMapping(value="/getRoomCurrInfo",method = RequestMethod.POST)
    public String getTeacherRoom(String jsonFile){
        //从json文件中解析数据，返回要加载的实验室信息，需要根据前端信息确定

        return "1";//这里返回 json "status": "0",其中0 表示预约成功
    }
}