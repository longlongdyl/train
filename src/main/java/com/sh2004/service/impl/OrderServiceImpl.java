package com.sh2004.service.impl;

import com.sh2004.bean.Order;
import com.sh2004.mapper.OrderMapper;
import com.sh2004.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: train
 * @Package: com.sh2004.service.impl
 * @Description: java类作用描述
 * @Author: 邓禹龙
 * @CreateDate: 2020/11/12 15:38
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int insert(List<Order> list) {
        int z =0;
        for (Order order : list) {
            int i = orderMapper.insert(order);
            z +=i;
        }
        return z;
    }

    @Override
    public List<Order> queryOrder(List<Order> list) {
        int z =0;
        List<Order> list1 = new ArrayList<>();
        for (Order order : list) {
            int i = orderMapper.selectCount(order);
            if (i==1){
                list1.add(order);
            }
        }
        return list1;
    }

    @Override
    public List<Map<String, String>> orderList(String uid) {
        return orderMapper.selectOrder(uid);
    }

    @Override
    public int deleteOrder(Order order) {
        return orderMapper.delete(order);
    }
}
