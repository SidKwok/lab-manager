package org.lab_manager.controller;
/**
 * Created by xiaofeige on 2016/5/22.
 */

import com.alibaba.fastjson.JSON;
import org.lab_manager.service.ILoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/log")
public class LoginController {
    @Resource
    private ILoginService loginService;
    /**
     *
     * params: username password
    {
    "status": "密码错误",
    "role": "teacher"
    }
     */
    @ResponseBody
    @RequestMapping(value="/in",method = RequestMethod.POST)
    public String login(@RequestBody String user) {
//        loginService.login()
        System.out.println("收到用户登录请求");
        Map<String,Object> result=new HashMap<String, Object>();
        if(1==1){
            result.put("status","success");
            result.put("role","manager");
        }else{
            result.put("status","密码错误");
            result.put("role","none");
        }
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping(value="/out",method = RequestMethod.POST)
    public String logout() {

        return "hello";
    }
}