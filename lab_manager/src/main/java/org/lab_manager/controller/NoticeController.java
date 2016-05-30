package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/22.
 */

import com.alibaba.fastjson.JSON;
import org.lab_manager.entity.Notice;
import org.lab_manager.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    private INoticeService noticeService;

    /**
    * 增加评论
     * params: noticeAuthor, noticeContent
     {
     "status": "0"
     }
    * */
    @ResponseBody
    @RequestMapping(value="/addNotice",method = RequestMethod.POST)
    public String addNotice(@RequestParam("noticeAuthor")String author,@RequestParam("noticeContent")String content) {
        //首先解析接收到的notice
        Map<String,Object> result=new HashMap<String, Object>();
        int flag=0;

        if(noticeService.addNotice(author,content))
            flag=1;

        result.put("status",flag);

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
        System.out.println("收到公告查询请求");
        List<Object> result=new ArrayList<Object>();

        //灌数据进去了
        List<Notice> notices = noticeService.queryAllNotice();
        for(Notice noticeSingle:notices){

            Map<String,Object> item=new HashMap<String, Object>();
            item.put("noticeId",noticeSingle.getNotice_id());
            item.put("noticeDate",noticeSingle.getDate());
            item.put("noticeContent",noticeSingle.getContent());
            item.put("noticeAuthor",noticeSingle.getAuthor());

            result.add(item);
        }

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