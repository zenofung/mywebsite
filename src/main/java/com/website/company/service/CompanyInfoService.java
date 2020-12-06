package com.website.company.service;

import com.website.company.entity.CompanyInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface CompanyInfoService extends IService<CompanyInfo> {

    //查看公司详细信息
    CompanyInfo getCompanyDetail();

    //新增公司信息
    void addCompany(CompanyInfo companyInfo);

    //修改公司信息
    void editCompany(CompanyInfo companyInfo);
}
