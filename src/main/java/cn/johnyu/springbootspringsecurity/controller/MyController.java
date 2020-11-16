package cn.johnyu.springbootspringsecurity.controller;

import cn.johnyu.springbootspringsecurity.domain.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MyController {
    @RequestMapping("/other")
    public String other(){
        return "other";
    }

    /**
     * 以下展示了三种获取用户信息的三种方式
     *
     */
    @GetMapping(value = "/username1")
    @ResponseBody
    public String userName1(Principal principal) {

        return principal.getName();
    }

    @GetMapping(value = "/username2")
    @ResponseBody
    public List<String> userName2() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        //获取所有的权限
        List<String> list= auth.getAuthorities()
                .stream()
               .map(a->a.getAuthority())
                .collect(Collectors.toList());
        return list;
    }

    @GetMapping(value = "/username3")
    @ResponseBody
    public List<String> userName3() {
       SysUser user=(SysUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        //获取所有的权限
        List<String> list= user.getAuthorities()
                .stream()
                .map(a->a.getAuthority())
                .collect(Collectors.toList());
        return list;
    }

    @ResponseBody
    @RequestMapping("/books")
    public String findAllBooks(){
        return "all books";
    }
}
