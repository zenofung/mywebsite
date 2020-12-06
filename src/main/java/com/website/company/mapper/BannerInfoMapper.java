package com.website.company.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.website.company.entity.BannerInfo;

import java.util.List;

public interface BannerInfoMapper extends BaseMapper<BannerInfo> {

    List<BannerInfo> selectBannerList();
}
