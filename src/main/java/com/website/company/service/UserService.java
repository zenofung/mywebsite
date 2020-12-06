package com.website.company.service;

import com.website.company.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.website.company.utils.ResponseList;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface UserService extends IService<User> {
    void add(User user);


    void update(User user);


    void delete(Integer[] ids);


    User show(Integer id);


    ResponseList<User> list(Integer page, Integer rows);

    User findUserByAccount(String account);

}
