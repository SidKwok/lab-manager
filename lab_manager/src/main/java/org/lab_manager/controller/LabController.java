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
//    @Resource
//    private ILabService labService;

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
    */
    @ResponseBody
    @RequestMapping(value="/_room_ajax",method = RequestMethod.GET)
    public String getRooms(){
//        List<LabInfo> list=labService.getAllLabRoom();
//        Map<String,Object> roomSingle=new HashMap<String, Object>();
//
//        List<Map<String,Object>> resultList=new ArrayList<Map<String, Object>>();
//        for(LabInfo lab:list){
//            roomSingle.put("room_id",lab.getID());
//            roomSingle.put("manage_teacher",lab.getManage_teacher());
//            roomSingle.put("intro",lab.getIntro());
//            resultList.add(roomSingle);
//            roomSingle.clear();
//        }
//        List<LabRoom> rooms=new ArrayList<LabRoom>();
//
//        return JSON.toJSONString(resultList);
        return "hello";
    }

    /**
    *获取所有房间信息
    */
    @ResponseBody
    @RequestMapping(value="/_get_room_comment",method = RequestMethod.POST)
    public String getRoomComment(int roomId){
        //从数据库中获取对应ID的实验室的评论信息

        return "添加评论成功";
    }

    /**
    *给房间添加评论
    */
    @ResponseBody
    @RequestMapping(value="/_add_room_comment",method = RequestMethod.POST)
    public String addRoomComment(String comment){
        //将获得的数据保存到数据库中

        return "添加评论成功";
    }

    /**
    *获取所有房间信息
    */
    @ResponseBody
    @RequestMapping(value="/room_order_info",method = RequestMethod.POST)
    public String getRoomStatus(int roomId){
        //将获得的数据保存到数据库中

        return "添加评论成功";
    }

    /**
    *预定实验室房间
    */
    @ResponseBody
    @RequestMapping(value="/_room_post_order",method = RequestMethod.POST)
    public String orderRoom(String jsonFile){
        //从json文件中解析数据，预定房间

        return "1";//这里返回 json "status": "0",其中0 表示预约成功
    }

    /**
    *实验室当前使用信息查询
    */
    @ResponseBody
    @RequestMapping(value="/_db_post_ajax",method = RequestMethod.POST)
    public String getTeacherRoom(String jsonFile){
        //从json文件中解析数据，返回要加载的实验室信息，需要根据前端信息确定

        return "1";//这里返回 json "status": "0",其中0 表示预约成功
    }
}