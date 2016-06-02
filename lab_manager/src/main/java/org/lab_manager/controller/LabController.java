package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/19.
 */
import com.alibaba.fastjson.JSON;
import org.lab_manager.entity.*;
import org.lab_manager.service.IExperimentService;
import org.lab_manager.service.ILabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private IExperimentService experimentService;
    /**
    * 预约实验
     * params: assetName, number, days, applicant
     {
     "status": "0"
     }
    * */
    @ResponseBody
    @RequestMapping(value="/orderLab",method = RequestMethod.POST)
    public String addLabOrder(@RequestParam("assetName")String assetName,@RequestParam("number")int number,@RequestParam("days")int days,@RequestParam("applicant")String applyer) {
        //根据上面的json格式要求返回数据，需查询数据库
        Map<String,Object> result=new HashMap<String, Object>();

        String flag="0";
//        if(experimentService.applyExp())
            flag="1";

        result.put("status",flag);
        return JSON.toJSONString(result);
    }

    /**
     * 实验室信息
     _labRoom_ajax (get) ok					()
     params: none
     [
     {
     "labRoomName": "机器人实验室"
     "labRoomId":"001"
     },
     {
     "labRoomName": "足球实验室"
     "labRoomId":"001"
     },
     {
     "labRoomName": "操蛋实验室"
     "labRoomId":"001"
     }
     ]
     * */
    @ResponseBody
    @RequestMapping(value="/getLabsInfo",method = RequestMethod.GET)
    public String getLabInfo() {
        //
        List<Object> result=new ArrayList<Object>();
        List<LabInfo> allLabRoom = labService.getAllLabRoom();
        for(LabInfo singleRoom:allLabRoom){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("labRoomName",singleRoom.getRoom_name());
            item.put("labRoomId",singleRoom.getRoom_id());
            result.add(item);
        }
        return JSON.toJSONString(result);
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
    @RequestMapping(value="/labUseStatus",method = RequestMethod.GET)
    public String getLabUseInfo() {
        //根据上面的json格式要求返回数据，需查询数据库
        List<Map<String,Object>> result=new ArrayList<Map<String, Object>>();
//        labService.getLabUseByRoomId()
        List<LabOrderState> allLabOrders=new ArrayList<LabOrderState>();
        for(LabOrderState singleOrder:allLabOrders){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("labOrderId",singleOrder.getID());
            item.put("labOrderName",singleOrder.getCourse_name());
            item.put("labOrderDate",singleOrder.getOrder_date());
            item.put("labOrderWeek",singleOrder.getStart_time());
            item.put("labOrderWeekday",singleOrder.getWeek_day());
            item.put("labOrderCourse",singleOrder.getCourse_name());
            item.put("labOrderApplicant",singleOrder.getTeacher());
            result.add(item);
        }

        return JSON.toJSONString(result);
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
    @RequestMapping(value="/confirmLabOrder",method = RequestMethod.POST)
    public String confirmOrder(@RequestParam("labOrderId")String id) {
        //根据上面的json格式要求返回数据，需查询数据库
        Map<String,String> result=new HashMap<String, String>();

        String flag="0";
//        if(labServi)
        result.put("status",flag);
        return JSON.toJSONString(result);
    }


    /**
    * 拒绝实验室预约
       _refuse_labOrder (post)
        params: labOrderId
        {
            "status": "0"
        }
    * */
    @ResponseBody
    @RequestMapping(value="/refuseLabOrder",method = RequestMethod.POST)
    public String refuseOrder(@RequestParam("labOrderId")String id) {
        //根据上面的json格式要求返回数据，需查询数据库

        Map<String,String> result=new HashMap<String, String>();
        result.put("status","0");
        return JSON.toJSONString(result);
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
        System.out.println("查询所有房间信息ajax请求收到");
        List<LabInfo> allLabRoom = labService.getAllLabRoom();

        List<Map<String,Object>> resultList=new ArrayList<Map<String, Object>>();

        for(LabInfo roomSingle:allLabRoom){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("room_id",roomSingle.getRoom_id());
            item.put("manage_teacher",roomSingle.getManage_teacher());
            item.put("intro",roomSingle.getIntro());
            resultList.add(item);
        }
        return JSON.toJSONString(resultList);
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
    public String getRoomComment(@RequestParam("roomId")String id){
        //从数据库中获取对应ID的实验室的评论信息
        Map<String,Object> result=new HashMap<String, Object>();
        //调用service获取数据然后加进去
        List<LabComment> labComments = labService.getLabComment(id);
        List<String> comments=new ArrayList<String>();
        for(LabComment item:labComments){
            comments.add(item.getComment());
        }
        result.put("comment",comments);

        return JSON.toJSONString(result);
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
    public String addRoomComment(@RequestParam("roomId")String id,@RequestParam("comment")String comment){
        //将获得的数据保存到数据库中
        Map<String,Object> result=new HashMap<String, Object>();
        String flag="0";
        if(labService.addComment(Integer.parseInt(id),comment))
            flag="1";
        result.put("status",flag);
        return JSON.toJSONString(result);
    }

    /**
    *获取特定房间使用情况
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
    public String getRoomStatus(@RequestParam("roomId")String roomId){

        System.out.println(roomId+"+++++++++++++++");
        List<Object> result=new ArrayList<Object>();

        List<Experiment> exps=labService.getLabUseByRoomId(roomId);
        for(Experiment labuseSingle:exps){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("labName",labuseSingle.getCourse_name());
            item.put("applicant",labuseSingle.getTeacher());
            item.put("week",labuseSingle.getStart_time());
            item.put("weekday",labuseSingle.getWeek());
            item.put("course",labuseSingle.getDay_time());
            result.add(item);
        }

        return JSON.toJSONString(result);
    }

    /**
    *预定实验室房间
     * params: roomId(实验室房间号), labName（申请的实验名称）, applicant（申请人）, startTime（开始周）, endTime（结束周）,weekday（周几）, dayTime（第几节课，比如1,2节课，单选框）
     {
     "status": "0"
     }
    */
    @ResponseBody
    @RequestMapping(value="/orderRoom",method = RequestMethod.POST)
    public String orderRoom(@RequestParam("roomId")String roomId,@RequestParam("labName")String labName,@RequestParam("applicant")String applicant,@RequestParam("startTime")String startTime,@RequestParam("endTime")String endTime,@RequestParam("weekday")String weekDay,@RequestParam("dayTime")String dayTime){
        //从json文件中解析数据，预定房间
        System.out.println(dayTime+"------");
        Map<String,Object> result= new HashMap<String, Object>();
        String flag="0";
        if(experimentService.applyExp(labName,Integer.parseInt(roomId),applicant,startTime,endTime,weekDay,dayTime))
            flag="1";
        result.put("status",flag);

        return JSON.toJSONString(result);//这里返回 json "status": "0",其中0 表示预约成功
    }

    /**
    *实验室当前使用信息查询
     * params: item, type (item是内容 type是类型 可选 lab/teacher)
     {
     "status": "1",
     "result":[
     {
     "teacher": "sid",
     "labName": "fuck",
     "roomId": "001",
     "labClass",
     "labStartTime",
     "labEndTime",
     "labWeekDay",
     "labCourse"
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
    public String getTeacherRoom(@RequestParam("item")String item,@RequestParam("type")String type){
        //从json文件中解析数据，返回要加载的实验室信息，需要根据前端信息确定
        Map<String,Object> result=new HashMap<String, Object>();
        String flag="0";

        List<Object> teacherInfo=new ArrayList<Object>();

        if(!type.equals("lab")){
//            labService.getLabUseByRoomId()

            flag="1";
        }else{
            List<Experiment> experiments = experimentService.getExperimentByName(item);
            for(Experiment singleExp:experiments){
                Map<String,Object> teaItem=new HashMap<String, Object>();
                teaItem.put("teacher",singleExp.getTeacher());
                teaItem.put("labName",singleExp.getCourse_name());
                teaItem.put("roomId",singleExp.getRoom_id());
                teaItem.put("labClass",singleExp.getClass_name());
                teaItem.put("labStartTime",singleExp.getStart_time());
                teaItem.put("labEndTime",singleExp.getEnd_time());
                teaItem.put("labWeekday",singleExp.getWeek());
                teaItem.put("labCourse",singleExp.getDay_time());
                teacherInfo.add(teaItem);
            }
            flag="1";
        }

        result.put("status",flag);
        result.put("result",teacherInfo);


        return JSON.toJSONString(result);//这里返回 json "status": "0",其中0 表示预约成功
    }

    /**
     * 删除实验室
     _del_labRoom (post) ok
     params: labRoomName(实验室名字)
     {
     "status": "0"
     }
     */
    @ResponseBody
    @RequestMapping(value="/delLabRoom",method = RequestMethod.POST)
    public String delLabRoom(@RequestParam("labRoomId")String labRoomId,@RequestParam("labRoomName")String labRoomName){
        //从json文件中解析数据，返回要加载的实验室信息，需要根据前端信息确定
        Map<String,Object> result=new HashMap<String, Object>();
        String flag="0";
        if(labService.deleteLabRoom(Integer.parseInt(labRoomId)))
            flag="1";
        result.put("status",flag);

        return JSON.toJSONString(result);//这里返回 json "status": "0",其中0 表示预约成功
    }

    /**
     * 实验室具体信息
     _labRoom_info (post) ok				()
     params: labRoomName(实验室名字)
     {
     "labRoomName":"机器人实验室",
     "labRoomType":"机器人",
     "labRoomIntro":"棒"
     }
     */
    @ResponseBody
    @RequestMapping(value="/roomConcreateInfo",method = RequestMethod.POST)
    public String getConcreatInfo(@RequestParam("labRoomId")String labRoomId){
        //从json文件中解析数据，返回要加载的实验室信息，需要根据前端信息确定
//        labService.g

        System.out.println(labRoomId+"...............");
        Map<String,Object> result=new HashMap<String, Object>();

        LabInfo labRoomInfo = labService.getLabRoomInfo(Integer.parseInt(labRoomId));
        result.put("labRoomName",labRoomInfo.getRoom_name());
        result.put("labRoomType",labRoomInfo.getManage_teacher());
        result.put("labRoomIntro",labRoomInfo.getIntro());

        return JSON.toJSONString(result);//这里返回 json "status": "0",其中0 表示预约成功
    }

    /**
     * 更新实验室信息
     _update_labRoom (post) ok
     params: labRoomName(实验室名字) labRoomType(实验室类型) labRoomIntro(实验室简介)
     {
     "status": "0"
     }
     */
    @ResponseBody
    @RequestMapping(value="/updateRoomInfo",method = RequestMethod.POST)
    public String updateLabRoomInfo(@RequestParam("labRoomId")String labRoomId,@RequestParam("labRoomName")String labRoomName,@RequestParam("labRoomType")String labRoomType,@RequestParam("labRoomIntro")String labRoomIntro){
        //从json文件中解析数据，返回要加载的实验室信息，需要根据前端信息确定
        Map<String,Object> result=new HashMap<String, Object>();
        String flag="0";
        if(labService.updateLabRoom(Integer.parseInt(labRoomId),labRoomType,labRoomName,labRoomIntro))
            flag="1";
        result.put("status",flag);

        return JSON.toJSONString(result);//这里返回 json "status": "0",其中0 表示预约成功
    }

    /**
     * 添加实验室
     _add_labRoom (post) ok
     params: labRoomName(实验室名字) labRoomType(实验室类型) labRoomIntro(实验室简介)，labRoomNo
     {
     "status": "0"
     }
     */
    @ResponseBody
    @RequestMapping(value="/addLabRoom",method = RequestMethod.POST)
    public String addLabRoom(@RequestParam("labRoomName")String labRoomName,@RequestParam("labRoomNo")String labRoomNo,@RequestParam("labRoomType")String labRoomtype,@RequestParam("labRoomIntro")String labRoomIntro){
        //从json文件中解析数据，返回要加载的实验室信息，需要根据前端信息确定
        Map<String,Object> result=new HashMap<String, Object>();
        String flag="0";
        if(labService.addLabRoom(Integer.parseInt(labRoomNo),labRoomName,labRoomtype,labRoomIntro))
            flag="1";

        result.put("status",flag);

        return JSON.toJSONString(result);//这里返回 json "status": "0",其中0 表示预约成功
    }
}