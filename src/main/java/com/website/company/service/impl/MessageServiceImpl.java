package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.website.company.entity.Message;
import com.website.company.mapper.MessageMapper;
import com.website.company.service.MessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.utils.Code;
import com.website.company.utils.ResponseList;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Override
    public int addMessage(Message message) {
        message.setCreateDatetime(new Date());
        message.setUpdateDatetime(new Date());
        return baseMapper.insert(message);
    }

    @Override
    public int deleteMessage(Integer id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public ResponseList<Message> getList(Integer page, Integer rows) {
        EntityWrapper<Message> entityWrapper = new EntityWrapper<>();
        entityWrapper.orderBy("update_datetime", false);
        int total = this.baseMapper.selectCount(entityWrapper);
        List<Message> list = this.baseMapper.selectPage(new Page<Message>(page, rows), entityWrapper);
        ResponseList<Message> responseList = new ResponseList<>();
        responseList.setCode(Code.SUCCESSED);
        responseList.setResult(list);
        responseList.setTotal(total);
        responseList.setPage(page);
        responseList.setRows(rows);
        responseList.setMsg("查询成功");
        return responseList;
    }

    @Override
    public Integer getNewMessage() {
        return baseMapper.getNewMessage();
    }
}
