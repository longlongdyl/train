package com.sh2004.mapper;

import com.sh2004.bean.Order;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: train
 * @Package: com.sh2004.mapper
 * @Description: java类作用描述
 * @Author: 邓禹龙
 * @CreateDate: 2020/11/12 15:38
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface OrderMapper extends Mapper<Order> {
    List<Map<String, String>> selectOrder(String uid);
}
