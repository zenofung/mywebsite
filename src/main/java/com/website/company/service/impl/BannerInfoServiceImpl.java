package com.website.company.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.entity.BannerInfo;
import com.website.company.mapper.BannerInfoMapper;
import com.website.company.service.BannerInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerInfoServiceImpl extends ServiceImpl<BannerInfoMapper,BannerInfo> implements BannerInfoService {


    @Override
    public List<BannerInfo> selectBannerList() {
        return this.baseMapper.selectBannerList();
    }
}
