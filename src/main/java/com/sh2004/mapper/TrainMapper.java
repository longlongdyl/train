package com.sh2004.mapper;

import com.sh2004.bean.Train;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: train
 * @Package: com.sh2004.mapper
 * @Description: java类作用描述
 * @Author: 邓禹龙
 * @CreateDate: 2020/11/12 11:11
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface TrainMapper extends Mapper<Train> {
    List<Train> queryAll(Train train);
}
