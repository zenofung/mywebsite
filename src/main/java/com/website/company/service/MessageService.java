package com.website.company.service;

import com.website.company.entity.Message;
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
public interface MessageService extends IService<Message> {

    //添加留言
    int addMessage(Message message);

    //删除留言
    int deleteMessage(Integer id);

    //查看所有留言
    ResponseList<Message> getList(Integer page, Integer rows);

    Integer getNewMessage();


}
