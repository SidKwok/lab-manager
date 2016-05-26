package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/22.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/equipment")
public class EquipController {
    /**
    *获取所有设备的名称列表
     * params: role, username
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
     "equit":[
     {
     "equitName": "西瓜刀",
     "equitDate": "2015-9-10",
     "equitOrderId": "001",
     "equitDays": "10",
     "equitNumber": "2",
     "state": "未决定"
     },
     {
     "equitName": "狼牙棒",
     "equitDate": "2015-11-10",
     "equitOrderId": "002",
     "equitDays": "2",
     "equitNumber": "10",
     "state": "未决定"
     }
     ]
     }
    */
    @ResponseBody
    @RequestMapping(value="/queryAllEquipment",method = RequestMethod.GET)
    public String getEquimentList(){
        //返回所有设备的名称列表，放到json中

        return "1";//
    }

    /**
    *获取单个设备信息
     * params: assetName
     {
     "classNo": "001",
     "className": "刀具",
     "valueType": "昂贵",
     "number": "10"
     }
    */
    @ResponseBody
    @RequestMapping(value="/queryEquipmentInfo",method = RequestMethod.GET)
    public String getEquimentInfo(){
        //返回所有设备的名称列表，放到json中

        return "1";//
    }

    /**
    *获取单个设备信息
    */
    @ResponseBody
    @RequestMapping(value="/update_equipment",method = RequestMethod.GET)
    public String updateEquimentInfo(){
        //返回所有设备的名称列表，放到json中

        return "1";//
    }

    /**
    *增加设备
    */
    @ResponseBody
    @RequestMapping(value="/add_equipment",method = RequestMethod.GET)
    public String addEquiment(){
        //返回所有设备的名称列表，放到json中

        return "1";//
    }

    /*
    *获取设备预约情况
    * params: none
[
  {
    "equitOrderId": "0003",
    "equitOrderName": "西瓜刀",
    "equitOrderNumber": "10",
    "equitOrderDay": "5",
    "equitOrderApplicant": "sid"
  },
  {
    "equitOrderId": "0004",
    "equitOrderName": "狼牙棒",
    "equitOrderNumber": "5",
    "equitOrderDay": "10",
    "equitOrderApplicant": "mingen"
  }
]
    */
    @ResponseBody
    @RequestMapping(value="/_equitOrder_ajax",method = RequestMethod.GET)
    public String getEquimentOrders(){
        //返回所有设备的预约信息，放到json中

        return "1";//
    }


    /*
    *增加设备
    * 批准设备预约
_confirm_equitOrder (post)
params: equitOrderId
{
  "status": "0"
}
    */
    @ResponseBody
    @RequestMapping(value="/_confirm_equitOrder",method = RequestMethod.POST)
    public String confirmEquiment(){
        //返回所有设备的名称列表，放到json中

        return "1";//
    }


    /*
    *拒绝设备预约
_refuse_equitOrder (post)
params: equitOrderId
{
  "status": "0"
}
    */
    @ResponseBody
    @RequestMapping(value="/_refuse_equitOrder",method = RequestMethod.POST)
    public String refuseEquiment(){
        //返回所有设备的名称列表，放到json中

        return "1";//
    }

}