package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.entity.HotWord;
import com.website.company.mapper.HotWordMapper;
import com.website.company.service.HotWordService;
import com.website.company.utils.Code;
import com.website.company.utils.ResponseList;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author pengyangyan
 */
@Service
public class HotWordServiceImpl extends ServiceImpl<HotWordMapper, HotWord> implements HotWordService {


    @Override
    public void add(HotWord hotWord) {
        HotWord one = baseMapper.selectOne(hotWord);
        if (one != null) {
            one.setUpdateDatetime(new Date());
            if (one.getFrequency() == 0 || one.getFrequency() == null) {
                one.setFrequency(1);
            } else {
                one.setFrequency(one.getFrequency() + 1);
            }
            baseMapper.updateById(one);
        } else {
            if (!StringUtils.isEmpty(hotWord.getWord())){
                hotWord.setCreateDatetime(new Date());
                hotWord.setUpdateDatetime(new Date());
                hotWord.setFrequency(1);
                baseMapper.insert(hotWord);
            }
        }
    }

    @Override
    public void update(HotWord hotWord) {
        hotWord.setUpdateDatetime(new Date());
        baseMapper.updateById(hotWord);
    }

    @Override
    public void delete(Integer[] ids) {
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public HotWord show(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public ResponseList<HotWord> list(Integer page, Integer rows) {
        EntityWrapper<HotWord> entityWrapper = new EntityWrapper<>();
        entityWrapper.orderBy("frequency",false);
        entityWrapper.orderBy("update_datetime",false);
        ResponseList<HotWord>  responses = new ResponseList<>();
        int count = baseMapper.selectCount(entityWrapper);
        List<HotWord> news = baseMapper.selectPage(new Page<HotWord>(page, rows), entityWrapper);
        responses.setRows(rows);
        responses.setPage(page);
        responses.setTotal(count);
        responses.setResult(news);
        responses.setCode(Code.SUCCESSED);
        responses.setMsg("操作成功");
        return responses;
    }

    @Override
    public List<HotWord> getHot(Integer num) {
        return baseMapper.getHot(num);
    }


}
