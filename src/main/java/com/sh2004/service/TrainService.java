package com.sh2004.service;

import com.sh2004.bean.Train;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: train
 * @Package: com.sh2004.service
 * @Description: java类作用描述
 * @Author: 邓禹龙
 * @CreateDate: 2020/11/12 11:10
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface TrainService {
    List<Train> list();

    List<Train> listAll(Train train);
}
