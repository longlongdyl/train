package com.sh2004.controller;

import com.alibaba.fastjson.JSONObject;
import com.sh2004.bean.Order;
import com.sh2004.bean.User;
import com.sh2004.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: train
 * @Package: com.sh2004.controller
 * @Description: java类作用描述
 * @Author: 邓禹龙
 * @CreateDate: 2020/11/12 15:38
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class OrderCotroller {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/buy")
    @ResponseBody
    public String buy(String otimes, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Order> list = new ArrayList<>();
        String[] otime = otimes.split(",");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < otime.length; i++) {
            Order order = new Order();
            order.setOtime(otime[i]);
            order.setUid(user.getUid());
            order.setOtime2(simpleDateFormat.format(new Date()));
            list.add(order);
        }
        int i = orderService.insert(list);
        System.out.println(i);
        return String.valueOf(i);
    }

    @RequestMapping("/queryOrder")
    @ResponseBody
    public String[] queryOrder(String otimes, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Order> list = new ArrayList<>();
        String[] otime = otimes.split(",");
        for (int i = 0; i < otime.length; i++) {
            Order order = new Order();
            order.setOtime(otime[i]);
            order.setUid(user.getUid());
            list.add(order);
        }
        List<Order> list1 = orderService.queryOrder(list);
        String str ="";
        for (Order order : list1) {
           str = str + order.getOtime()+",";
        }
        System.out.println(str.length());
        return str.split(",");
    }

    @RequestMapping("/orderList")
    @ResponseBody
    public List<Map<String, String>> orderList(String uid){
        List<Map<String, String>> list = orderService.orderList(uid);
        return list;
    }


    @RequestMapping("/deleteOrder")
    @ResponseBody
    public String deleteOrder(Order order){
        int i = orderService.deleteOrder(order);
        if (i>0){
            return "删除成功";
        }
        return "删除失败";
    }


}
