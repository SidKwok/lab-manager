package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/22.
 */

import com.alibaba.fastjson.JSON;
import org.lab_manager.entity.EquipInfo;
import org.lab_manager.service.IEquipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/equipment")
public class EquipController {
    @Resource
    private IEquipService equipService;

    /**
    *获取所有设备的名称列表
     * params: none
     [
     {
     "assetName": "西瓜刀"
     },
     {
     "assetName": "狼牙棒"
     }
     ]
    */
    @ResponseBody
    @RequestMapping(value="/queryAllEquipment",method = RequestMethod.GET)
    public String getEquimentList(String json){
        //返回所有设备的名称列表，放到json中
        List<Map<String,String>> result= new ArrayList<Map<String, String>>();
        Map<String,String> item=new HashMap<String, String>();

        List<EquipInfo> allEquipInfo = equipService.getAllEquipInfo();
        for(EquipInfo singleEquip:allEquipInfo){
//            item.put("assetName",singleEquip.getName());
            result.add(item);
            item.clear();
        }

        return JSON.toJSONString(result);//
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
    @RequestMapping(value="/queryEquipmentInfo",method = RequestMethod.POST)
    public String getEquimentInfo(@RequestBody String json){
        //返回所有设备的名称列表，放到json中
        Map<String,String> result=new HashMap<String, String>();
        EquipInfo equipInfo = equipService.queryEquipById(json);
//        result.put("classNo",equipInfo.);
        return JSON.toJSONString(result);//
    }

    /**
    *更新单个设备信息
     *
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

    /**
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


    /**
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


    /**
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