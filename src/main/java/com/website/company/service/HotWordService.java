package com.website.company.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.website.company.entity.HotWord;
import com.website.company.utils.ResponseList;

import java.util.List;

public interface HotWordService extends IService<HotWord> {

    void add(HotWord hotWord);


    void update(HotWord hotWord);


    void delete(Integer[] ids);


    HotWord show(Integer id);


    ResponseList<HotWord> list(Integer page, Integer rows);

    List<HotWord> getHot(Integer num);
}
