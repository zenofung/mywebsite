package com.website.company.service;

import com.website.company.entity.FunctionClass;
import com.baomidou.mybatisplus.service.IService;
import com.website.company.utils.Response;
import com.website.company.utils.ResponseList;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface FunctionClassService extends IService<FunctionClass> {
    //新增
    void addFunction(FunctionClass functionClass);

    //修改
    void editFunction(FunctionClass functionClass);

    //删除
    void deleteFunction(Integer[] ids);

    //查看
    FunctionClass showFunction(Integer id);

    //列表
    ResponseList<FunctionClass> listFunction(Integer page, Integer rows, Integer classCode);
}
