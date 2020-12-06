package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.website.company.entity.FunctionClass;
import com.website.company.mapper.FunctionClassMapper;
import com.website.company.service.FunctionClassService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.utils.Code;
import com.website.company.utils.ResponseList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@Service
public class FunctionClassServiceImpl extends ServiceImpl<FunctionClassMapper, FunctionClass> implements FunctionClassService {

    private static Logger logger = LoggerFactory.getLogger(FunctionClassServiceImpl.class);

    @Override
    public void addFunction(FunctionClass functionClass) {
        functionClass.setCreateDatetime(new Date());
        functionClass.setUpdateDatetime(new Date());
        baseMapper.insert(functionClass);
    }

    @Override
    public void editFunction(FunctionClass functionClass) {
        functionClass.setUpdateDatetime(new Date());
        baseMapper.updateById(functionClass);
    }


    @Override
    public void deleteFunction(Integer[] ids) {
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public FunctionClass showFunction(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public ResponseList<FunctionClass> listFunction(Integer page, Integer rows, Integer classCode) {
        ResponseList<FunctionClass> list = new ResponseList<>();
        EntityWrapper<FunctionClass> entityWrapper = new EntityWrapper<>();
        entityWrapper.orderBy("update_datetime", false);
        if (classCode != null) {
            entityWrapper.eq("class_code", classCode);
        }
        int count = baseMapper.selectCount(entityWrapper);
        List<FunctionClass> res = baseMapper.selectPage(new Page<FunctionClass>(page, rows), entityWrapper);
        list.setTotal(count);
        list.setResult(res);
        list.setCode(Code.SUCCESSED);
        list.setTotalPage(count / rows + 1);
        list.setPage(page);
        list.setRows(rows);
        return list;
    }
}
