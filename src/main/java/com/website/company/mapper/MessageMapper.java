package com.website.company.mapper;

import com.website.company.entity.Message;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface MessageMapper extends BaseMapper<Message> {
        Integer getNewMessage();
}