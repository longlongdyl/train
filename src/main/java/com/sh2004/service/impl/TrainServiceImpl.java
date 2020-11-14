package com.sh2004.service.impl;

import com.sh2004.bean.Train;
import com.sh2004.mapper.TrainMapper;
import com.sh2004.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: train
 * @Package: com.sh2004.service.impl
 * @Description: java类作用描述
 * @Author: 邓禹龙
 * @CreateDate: 2020/11/12 11:10
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service("trainService")
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainMapper trainMapper;

    @Override
    public List<Train> list() {
        return trainMapper.selectAll();
    }

    @Override
    public List<Train> listAll(Train train) {
        return trainMapper.queryAll(train);
    }
}
