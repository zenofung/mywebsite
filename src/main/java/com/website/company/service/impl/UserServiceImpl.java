package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.website.company.entity.User;
import com.website.company.mapper.UserMapper;
import com.website.company.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.utils.Code;
import com.website.company.utils.ResponseList;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void add(User user) {
        user.setCreateDatetime(new Date());
        user.setUpdateDatetime(new Date());
        baseMapper.insert(user);
    }

    @Override
    public void update(User user) {
        user.setUpdateDatetime(new Date());
        baseMapper.updateById(user);
    }

    @Override
    public void delete(Integer[] ids) {
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public User show(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public ResponseList<User> list(Integer page, Integer rows) {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.orderBy("update_datetime", false);
        ResponseList<User> responses = new ResponseList<>();
        int count = baseMapper.selectCount(entityWrapper);
        List<User> news = baseMapper.selectPage(new Page<User>(page, rows), entityWrapper);
        responses.setRows(rows);
        responses.setPage(page);
        responses.setTotal(count);
        responses.setResult(news);
        responses.setCode(Code.SUCCESSED);
        responses.setMsg("操作成功");
        return responses;
    }

    @Override
    public User findUserByAccount(String account) {
        User user = new User();
        user.setLoginAccount(account);
        return baseMapper.selectOne(user);
    }
}
