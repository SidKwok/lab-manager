package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/22.
 */

import com.alibaba.fastjson.JSON;
import org.lab_manager.entity.EquipInfo;
import org.lab_manager.entity.EquipOrder;
import org.lab_manager.service.IEquipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    public String getEquimentList(){
        //返回所有设备的名称列表，放到json中
        List<Object> result=new ArrayList<Object>();


        List<EquipInfo> allEquipInfo = equipService.getAllEquipInfo();
        for(EquipInfo singleEquip:allEquipInfo){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("assetName",singleEquip.getAsset_name());
            result.add(item);
        }

        Map<String,Object> item=new HashMap<String, Object>();
        item.put("assetName","无尽之刃");
        result.add(item);
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
    public String getEquimentInfo(@RequestParam("assetName") String assetName){
        //返回所有设备的名称列表，放到json中
        Map<String,Object> result=new HashMap<String, Object>();
        EquipInfo equipInfo = equipService.queryEquipById(assetName);
        result.put("classNo",equipInfo.getClass_no());
        result.put("className",equipInfo.getClass_name());
        result.put("valueType",equipInfo.getValue_type());
        result.put("number",equipInfo.getNumber());

        return JSON.toJSONString(result);//
    }


    /**
     *预约设备
     * params: assetName(设备名), number(数量), days(申请天数), applicant(申请人)
     {
     "status": "0"
     }
     */
    @ResponseBody
    @RequestMapping(value="/orderEquip",method = RequestMethod.POST)
    public String orderEquipment(@RequestParam("assetName")String assetName,@RequestParam("number")int num,@RequestParam("days")int days,@RequestParam("applicant")String apllyer){
        //返回所有设备的名称列表，放到json中
        Map<String,Object> result=new HashMap<String, Object>();

        int flag=0;
        if(equipService.addEquipOrder(assetName,num,days,apllyer))
            flag=1;

        result.put("status",flag);

        return JSON.toJSONString(result);//
    }

    /**
    *更新单个设备信息
     * params: assetName(设备名), classNo(分类编号), className(分类类别), valueType(价值类型), number(数量)
     {
     "status": "0"
     }
     *
    */
    @ResponseBody
    @RequestMapping(value="/updateEquipment",method = RequestMethod.POST)
    public String updateEquimentInfo(@RequestParam("assetName")String assetName,@RequestParam("classNo")String classNo,@RequestParam("className")String className,@RequestParam("valueType")String valueType,@RequestParam("number")int number){
        Map<String,Object> result=new HashMap<String, Object>();

        result.put("status",1);

        return JSON.toJSONString(result);//
    }

    /**
    *增加设备
     * params: assetName(设备名), classNo(分类编号), className(分类类别), valueType(价值类型), number(数量)
     {
     "status": "0"
     }
    */
    @ResponseBody
    @RequestMapping(value="/addEquipment",method = RequestMethod.POST)
    public String addEquiment(@RequestParam("assetName")String assetName,@RequestParam("classNo")String classNo,@RequestParam("className")String className,@RequestParam("valueType")String valueType,@RequestParam("number")int number){
        Map<String,Object> result=new HashMap<String, Object>();

        result.put("status",1);

        return JSON.toJSONString(result);//
    }

    /**
     *删除仪器设备
     * params: assetName(设备名)
     {
     "status": "0"
     }
     */
    @ResponseBody
    @RequestMapping(value="/delEquipment",method = RequestMethod.POST)
    public String delEquiment(@RequestParam("assetName")String assetName){
        Map<String,Object> result=new HashMap<String, Object>();

        result.put("status",1);

        return JSON.toJSONString(result);//
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
    @RequestMapping(value="/equipOrderStatus",method = RequestMethod.GET)
    public String getEquimentOrders(){
        //返回所有设备的预约信息，放到json中
        List<Map<String,Object>> result=new ArrayList<Map<String, Object>>();
        List<EquipOrder> allEquipOrder  = equipService.getAllEquipOrder();
        for(EquipOrder orderSingle:allEquipOrder){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("equitOrderId","001");
            item.put("equitOrderName",orderSingle.getDevice_name());
            item.put("equitOrderNumber",orderSingle.getEquip_number());
            item.put("equitOrderDay",orderSingle.getDays());
            item.put("equitOrderApplicant",orderSingle.getApplicant());
            result.add(item);
        }
        return JSON.toJSONString(result);//
    }


    /**
    *批准设备预约
     _confirm_equitOrder (post)
     params: equipOrderId   (菊花有可能打错字了)
     {
     "status": "0"
     }
    *
    */
    @ResponseBody
    @RequestMapping(value="/confirmEquipOrder",method = RequestMethod.POST)
    public String confirmEquiment(@RequestParam("equipOrderId")String id){
        Map<String,Object> result=new HashMap<String, Object>();
        int flag=0;
        if(equipService.approveOrderEquip(Integer.parseInt(id)));
            flag=1;
        result.put("status",flag);

        return JSON.toJSONString(result);//
    }


    /**
    *拒绝设备预约
     _refuse_equipOrder (post)
     params: equipOrderId
     {
     "status": "0"
     }
    */
    @ResponseBody
    @RequestMapping(value="/refuseEquipOrder",method = RequestMethod.POST)
    public String refuseEquiment(@RequestParam("equipOrderId")String id){
        Map<String,Object> result=new HashMap<String, Object>();
        int flag=0;
        if(equipService.refuseOrderEquip(Integer.parseInt(id)))
            flag=1;
        result.put("status",flag);
        return JSON.toJSONString(result);//
    }

}