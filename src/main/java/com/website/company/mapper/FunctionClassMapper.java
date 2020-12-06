package com.website.company.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.website.company.entity.FunctionClass;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface FunctionClassMapper extends BaseMapper<FunctionClass> {

    List<FunctionClass> showMoreFunction(@Param("classCode") Integer classCode, @Param("from") Integer from, @Param("to") Integer to);
}