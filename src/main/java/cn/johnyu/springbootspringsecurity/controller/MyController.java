package cn.johnyu.springbootspringsecurity.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MyController {
    @RequestMapping("/other")
    public String other(){
        return "other";
    }

    /**
     * 获取当前登录用户的用户名
     * @param principal
     * @return
     */
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        
        return principal.getName();
    }
}
