package com.sh2004.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sh2004.bean.Train;
import com.sh2004.service.TrainService;
import com.sh2004.util.PageHelpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: train
 * @Package: com.sh2004.controller
 * @Description: java类作用描述
 * @Author: 邓禹龙
 * @CreateDate: 2020/11/12 10:07
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class TrainCotroller {

    @Autowired
    private TrainService trainService;

    @RequestMapping("/toView/{view}")
    public String toView(@PathVariable("view") String string){
        return string;
    }

    @RequestMapping({"/train","/"})
    public String toIndex(Model model , @RequestParam(defaultValue = "1")
            int page,Train train){
        PageHelper.startPage(page, 4);
        List<Train> trains = trainService.listAll(train);
        List<Train> tnumbers = trainService.list();
        model.addAttribute("tnumbers",tnumbers);
        PageInfo<Train> pageInfo = new PageInfo<>(trains);
        String pages = PageHelpUtil.bootStrapPage("/train/train", pageInfo, null);
        model.addAttribute("trains",trains);
        model.addAttribute("t",train);
        model.addAttribute("pages",pages);
        return "traintable";
    }

    @RequestMapping("/trainList")
    @ResponseBody
    public List<String> trainList(){
        List<Train> list = trainService.list();
        List<String> strings = new ArrayList<>();
        String start ="";
        String end = "";
        for (Train train : list) {
            String[] split = train.getTaddress().split("-");
            start += split[0]+",";
            end += split[1]+",";
        }
        start = start.substring(0,start.length()-1);
        end = end.substring(0,start.length()-1);
        strings.add(start);
        strings.add(end);
        return strings;
    }



}
