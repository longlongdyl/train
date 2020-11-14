package com.sh2004.controller;

import com.sh2004.bean.User;
import com.sh2004.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ProjectName: train
 * @Package: com.sh2004.controller
 * @Description: java类作用描述
 * @Author: 邓禹龙
 * @CreateDate: 2020/11/12 10:09
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            return "forward:/train";
        }else {
            User user1 = userService.login(user);
            if (user1 != null){
                session.setAttribute("user",user1);
                return "forward:/train";
            }
            return "login";
        }
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        System.out.println("我跟你删了");
        System.out.println("郭哲宇到此二游");
        System.out.println("王勇强到此一游");
        return "forward:/train";
    }

}
