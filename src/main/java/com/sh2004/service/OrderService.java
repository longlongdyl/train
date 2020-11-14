package com.sh2004.service;

import com.sh2004.bean.Order;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: train
 * @Package: com.sh2004.service
 * @Description: java类作用描述
 * @Author: 邓禹龙
 * @CreateDate: 2020/11/12 15:38
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface OrderService {

    int insert(List<Order> list);

    List<Order> queryOrder(List<Order> list);

    List<Map<String, String>> orderList(String uid);

    int deleteOrder(Order order);
}
