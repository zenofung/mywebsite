package com.website.company.service;

import com.baomidou.mybatisplus.service.IService;
import com.website.company.entity.PatentInfo;
import com.website.company.utils.ResponseList;
import com.website.company.utils.entityVO.PatentInfoVO;

import java.util.List;

public interface PatentInfoService extends IService<PatentInfo> {

    List<PatentInfo> patentInfoList();

    //页面家在获取一条证书
    PatentInfoVO getPatentInfo();

    PatentInfoVO ajaxGetPatentInfo(Integer id, Integer key);

    int PatentCount();


}
