package com.website.company.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.entity.PatentInfo;
import com.website.company.mapper.PatentInfoMapper;
import com.website.company.service.PatentInfoService;
import com.website.company.utils.ResponseList;
import com.website.company.utils.entityVO.PatentInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PatentInfoServiceImpl extends ServiceImpl<PatentInfoMapper, PatentInfo> implements PatentInfoService {

    @Override
    public List<PatentInfo> patentInfoList() {
        EntityWrapper<PatentInfo> entityWrapper = new EntityWrapper<>();
        return baseMapper.selectList(entityWrapper.orderBy("apply_date", false));
    }

    @Override
    public PatentInfoVO getPatentInfo() {
        EntityWrapper<PatentInfo> entityWrapper = new EntityWrapper<>();
        entityWrapper.orderBy("id", true);
        entityWrapper.last("limit 1");
        List<PatentInfo> patentInfos = baseMapper.selectList(entityWrapper);
        if (patentInfos.size() < 1) {
            return new PatentInfoVO();
        }
        return patentInfoToVO(patentInfos.get(0));
    }

    private PatentInfoVO patentInfoToVO(PatentInfo patentInfo) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(patentInfo.getApplyDate());
        PatentInfoVO patentInfoVO = new PatentInfoVO();
        BeanUtils.copyProperties(patentInfo, patentInfoVO);
        patentInfoVO.setApplyDate(dateString);
        return patentInfoVO;
    }

    @Override
    public PatentInfoVO ajaxGetPatentInfo(Integer id, Integer key) {
        EntityWrapper<PatentInfo> entityWrapper = new EntityWrapper<>();
        List<PatentInfo> patentInfos = null;
        if (key == 1) {
            entityWrapper.gt("id", id);
            entityWrapper.orderBy("id", true);
            patentInfos = baseMapper.selectList(entityWrapper);
            if (patentInfos.size() < 1) {
                EntityWrapper<PatentInfo> entityWrapper1 = new EntityWrapper<>();
                entityWrapper1.orderBy("id", true);
                entityWrapper1.last("limit 1");
                List<PatentInfo> patentInfos1 = baseMapper.selectList(entityWrapper1);
                return patentInfoToVO(patentInfos1.get(0));
            }
        } else {
            entityWrapper.lt("id", id);
            entityWrapper.orderBy("id", false);
            patentInfos = baseMapper.selectList(entityWrapper);
            if (patentInfos.size() < 1) {
                EntityWrapper<PatentInfo> entityWrapper1 = new EntityWrapper<>();
                entityWrapper1.orderBy("id", false);
                entityWrapper1.last("limit 1");
                List<PatentInfo> patentInfos1 = baseMapper.selectList(entityWrapper1);
                return patentInfoToVO(patentInfos1.get(0));
            }
        }
        return patentInfoToVO(patentInfos.get(0));
    }

    @Override
    public int PatentCount() {
        EntityWrapper<PatentInfo> entityWrapper = new EntityWrapper<>();
        int count = baseMapper.selectCount(entityWrapper);
        return count;
    }
}
