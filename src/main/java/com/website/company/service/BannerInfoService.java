package com.website.company.service;

import com.baomidou.mybatisplus.service.IService;
import com.website.company.entity.BannerInfo;

import java.util.List;

public interface BannerInfoService extends IService<BannerInfo> {

   List<BannerInfo> selectBannerList();
}
