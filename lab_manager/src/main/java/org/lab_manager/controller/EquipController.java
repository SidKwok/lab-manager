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
     * _equip_ajax (get) ok  (/equipment/queryAllEquipment)
     params: none
     [
     {
     "assetId": "0001",
     "assetName": "西瓜刀"
     },
     {
     "assetId": "0002",
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
            item.put("assetId",singleEquip.getID());
            result.add(item);
        }
        return JSON.toJSONString(result);//
    }

    /**
    *获取单个设备信息
     * _equip_info (post) ok   (/equipment/queryEquipmentInfo)
     params: assetName(设备名) assetId(设备id)
     {
     "classNo": "001",
     "className": "刀具",
     "valueType": "昂贵",
     "originName": "",
     "purchaseUnit": "",
     "valueType": "",
     "unitPrice": "",
     "invoiceNum": "",
     "measurementUnit": "",
     "purchaseDate": "",
     "financialRes": "",
     "assetRes": "",
     "handlePerson": "",
     "chargeType": "",
     "checkDate": "",
     "receptDate": "",
     "purchaseForm": "",
     "managePart": "",
     "subjectType": "",
     "subject": "",
     "remark": "",
     "finantialOpinion": "",
     "purchasingAgent": "",
     "modal": "",
     "standard": "",
     "productionDate": "",
     "country": "",
     "manufacture": "",
     "brand": "",
     "power": "",
     "estimatedExpirationDate": "",
     "durableYears": "",
     "retailer": "",
     "number": ""
     }
    */
    @ResponseBody
    @RequestMapping(value="/queryEquipmentInfo",method = RequestMethod.POST)
    public String getEquimentInfo(@RequestParam("assetName") String assetName,@RequestParam("assetId") String assetId){
        //返回所有设备的名称列表，放到json中
        Map<String,Object> result=new HashMap<String, Object>();
        EquipInfo equipInfo = equipService.queryEquipById(assetId);
        result.put("classNo",equipInfo.getClass_no());
        result.put("className",equipInfo.getClass_name());
        result.put("valueType",equipInfo.getValue_type());
        result.put("number",equipInfo.getNumber());
        result.put("originName",equipInfo.getOrigin_name());
        result.put("purchaseUnit",equipInfo.getPurchase_unit());
        result.put("unitPrice",equipInfo.getUnit_price());
        result.put("invoiceNum",equipInfo.getInvoice_num());
        result.put("measurementUnit",equipInfo.getMeasurement_unit());
        result.put("purchaseDate",equipInfo.getPurchase_date());
        result.put("purchaseForm",equipInfo.getPurchase_form());
        result.put("financialRes",equipInfo.getFinancial_res());
        result.put("assetRes",equipInfo.getAsset_res());
        result.put("handlePerson",equipInfo.getHandle_person());
        result.put("chargeType",equipInfo.getCharge_type());
        result.put("checkDate",equipInfo.getCheck_date());
        result.put("receptDate",equipInfo.getRecept_date());
        result.put("managePart",equipInfo.getManage_part());
        result.put("subjectType",equipInfo.getSubject_type());
        result.put("subject",equipInfo.getSubject());
        result.put("remark",equipInfo.getRemark());
        result.put("finantialOpinion",equipInfo.getFinantial_opinion());
        result.put("purchasingAgent",equipInfo.getPurchasing_agent());
        result.put("modal",equipInfo.getModel());
        result.put("standard",equipInfo.getStandard());
        result.put("productionDate",equipInfo.getProduction_date());
        result.put("country",equipInfo.getCountry());
        result.put("manufacture",equipInfo.getManufacturer());
        result.put("brand",equipInfo.getBrand());
        result.put("power",equipInfo.getPower());
        result.put("estimatedExpirationDate",equipInfo.getEstimated_expiration_date());
        result.put("durableYears",equipInfo.getDurable_years());
        result.put("retailer",equipInfo.getRetailer());
        result.put("number",equipInfo.getNumber());

        System.out.println(equipInfo.getNumber());
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
     * params: assetName(设备名), classNo(分类编号), className(分类类别), valueType(价值类型), number(数量)， assetId(设备id)
     {
     "status": "0"
     }
     *
    */
    @ResponseBody
    @RequestMapping(value="/updateEquipment",method = RequestMethod.POST)
    public String updateEquimentInfo(@RequestParam("assetName")String assetName,@RequestParam("classNo")String classNo,@RequestParam("className")String className,@RequestParam("valueType")String valueType,@RequestParam("number")String number,@RequestParam("assetId")String assetId){
        Map<String,Object> result=new HashMap<String, Object>();

        int flag=0;
        if(equipService.updateEquipInfo(Integer.parseInt(assetId),assetName,Integer.parseInt(classNo),className,valueType,Integer.parseInt(number)))
            flag=1;
        result.put("status",flag);

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
    public String addEquiment(@RequestParam("assetName")String assetName,@RequestParam("classNo")String classNo,@RequestParam("className")String className,@RequestParam("valueType")String valueType,@RequestParam("number")String number){
        Map<String,Object> result=new HashMap<String, Object>();

        int flag=0;
        if(equipService.addEquip(assetName,Integer.parseInt(classNo),className,valueType,Integer.parseInt(number)))
            flag=1;
        result.put("status",flag);

        return JSON.toJSONString(result);//
    }

    /**
     *删除仪器设备
     * params: assetName(设备名)，assetId(设备id)
     {
     "status": "0"
     }
     */
    @ResponseBody
    @RequestMapping(value="/delEquipment",method = RequestMethod.POST)
    public String delEquiment(@RequestParam("assetName")String assetName,@RequestParam("assetId")String assetId){
        System.out.println(assetId+"zheshishi");
        Map<String,Object> result=new HashMap<String, Object>();
        int flag=0;
        if(equipService.deleteEquipById(assetId))
            flag=1;
        result.put("status",flag);

        return JSON.toJSONString(result);//
    }

    /**
    *获取设备预约情况
    * _equipOrder_ajax (get) ok		(/equipment/equitOrderStatus)
     params: none
     [
     {
     "equipOrderId": "0003",
     "equipOrderName": "西瓜刀",
     "equipOrderNumber": "10",
     "equipOrderDay": "5",
     "equipOrderApplicant": "sid",
     "equipOrderDate": "2016-5-7"
     },
     {
     "equipOrderId": "0004",
     "equipOrderName": "狼牙棒",
     "equipOrderNumber": "5",
     "equipOrderDay": "10",
     "equipOrderApplicant": "mingen",
     "equipOrderDate": "2016-5-7"
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
            item.put("equipOrderId",orderSingle.getOrder_id());
            item.put("equipOrderName",orderSingle.getDevice_name());
            item.put("equipOrderNumber",orderSingle.getEquip_number());

            item.put("equipOrderDay",orderSingle.getStart_time());

            item.put("equipOrderApplicant",orderSingle.getApplicant());
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