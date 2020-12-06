package com.website.company.mapper;

import com.website.company.entity.CompanyInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface CompanyInfoMapper extends BaseMapper<CompanyInfo> {

    List<CompanyInfo> selectCompanyInfo();
}