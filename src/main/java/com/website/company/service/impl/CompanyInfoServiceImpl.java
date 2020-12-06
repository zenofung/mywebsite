package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.CompanyInfo;
import com.website.company.mapper.CompanyInfoMapper;
import com.website.company.service.CompanyInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@Service
public class CompanyInfoServiceImpl extends ServiceImpl<CompanyInfoMapper, CompanyInfo> implements CompanyInfoService {

    @Override
    public CompanyInfo getCompanyDetail() {
        CompanyInfo companyInfo = new CompanyInfo();
        List<CompanyInfo> companyInfos = baseMapper.selectCompanyInfo();
        if (companyInfos.size() < 1 ){
            return companyInfo;
        }else {
            return companyInfos.get(0);
        }
    }

    @Override
    public void addCompany(CompanyInfo companyInfo) {
        companyInfo.setCreateDatetime(new Date());
        companyInfo.setUpdateDatetime(new Date());
        baseMapper.insert(companyInfo);

    }

    @Override
    public void editCompany(CompanyInfo companyInfo) {
        companyInfo.setUpdateDatetime(new Date());
        baseMapper.updateById(companyInfo);
    }

}
