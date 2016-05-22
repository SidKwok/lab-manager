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
@RequestMapping("/comment")
public class CommentController {
    @ResponseBody
    @RequestMapping(value="/addComment",method = RequestMethod.POST)
    public String printWelcome() {
        System.out.println("ajax响应");
        return "ajax 调用成功";
    }
}