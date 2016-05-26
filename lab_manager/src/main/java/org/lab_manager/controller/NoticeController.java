package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/22.
 */

import com.alibaba.fastjson.JSON;
import org.lab_manager.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    INoticeService noticeService;

    /**
    * 增加评论
     * params: noticeAuthor, noticeContent
     {
     "status": "0"
     }
    * */
    @ResponseBody
    @RequestMapping(value="/addNotice",method = RequestMethod.POST)
    public String addNotice(@RequestBody String notice) {
        //首先解析接收到的notice
        Map<String,String> result=new HashMap<String, String>();
        result.put("status","0");

        //这里肯定会需要用到时间等函数，在util中使用已经完成的工具类
        return JSON.toJSONString(result);
    }

    /**
    * 删除评论--管理员特有权限
    * */
    @ResponseBody
    @RequestMapping(value="/deleteNotice",method = RequestMethod.POST)
    public String deleteNotice() {
        System.out.println("ajax响应");
        return "ajax 调用成功";
    }

    /**
    * 查询评论---支持分页功能
     * params: none
     [
     {
     "noticeId": "0001",
     "noticeDate": "2016-5-21",
     "noticeContent": "Sid is the best!",
     "noticeAuthor": "sid"
     },
     {
     "noticeId": "0002",
     "noticeDate": "2016-5-21",
     "noticeContent": "Mingen is the best!",
     "noticeAuthor": "mingen"
     }
     ]
    * */
    @ResponseBody
    @RequestMapping(value="/queryAllNotice",method = RequestMethod.GET)
    public String queryAllNotice() {
        List<Map<String,String>> result=new ArrayList<Map<String, String>>();
        Map<String,String> item=new HashMap<String, String>();

        //灌数据进去了


        return JSON.toJSONString(result);
    }

    /**
    * 修改评论，暂定能不能修改
    * */
    @ResponseBody
    @RequestMapping(value="/updateNotice",method = RequestMethod.POST)
    public String updateNotice() {
        System.out.println("ajax响应");
        return "ajax 调用成功";
    }
}