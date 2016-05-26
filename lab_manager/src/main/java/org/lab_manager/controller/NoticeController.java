package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/22.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;


@Controller
@RequestMapping("/notice")
public class NoticeController {
    /**
    * 增加评论
     * params: noticeAuthor, noticeContent
     {
     "status": "0"
     }
    * */
    @ResponseBody
    @RequestMapping(value="/addNotice",method = RequestMethod.POST)
    public String addComment() {
        System.out.println("ajax响应");
        return "ajax 调用成功";
    }

    /**
    * 删除评论--管理员特有权限
    * */
    @ResponseBody
    @RequestMapping(value="/deleteComment",method = RequestMethod.POST)
    public String deleteComment() {
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
    public String queryComment() {
        System.out.println("ajax响应");
        return "ajax 调用成功";
    }

    /**
    * 修改评论，暂定能不能修改
    * */
    @ResponseBody
    @RequestMapping(value="/updateComment",method = RequestMethod.POST)
    public String updateComment() {
        System.out.println("ajax响应");
        return "ajax 调用成功";
    }
}