package com.website.company.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.website.company.entity.HotWord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotWordMapper extends BaseMapper<HotWord> {

    List<HotWord> getHot(@Param("num") Integer num);

    /**
     * 热搜词分页查询
     * @param pages (page-1)*row
     * @param row  row
     * @return
     */
    List<HotWord> getHotListPage(@Param("pages") Integer pages,@Param("row") Integer row);
}
