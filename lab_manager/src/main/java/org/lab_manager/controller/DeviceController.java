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
public class DeviceController {
    /**
    *获取所有设备的名称列表
    */
    @ResponseBody
    @RequestMapping(value="/_equit_ajax",method = RequestMethod.GET)
    public String getEquimentList(){
        //返回所有设备的名称列表，放到json中

        return "1";//
    }

    /**
    *获取单个设备信息
    */
    @ResponseBody
    @RequestMapping(value="/_equit_info",method = RequestMethod.GET)
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