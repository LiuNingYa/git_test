package com.liuning.service.impl;

import com.liuning.pojo.User;
import com.liuning.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

@Service
public class UserMapperIpml implements UserMapper {

    @Autowired
    private com.liuning.mapper.UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectList(null);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public Integer insert(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public Integer update(User user) {
        int update = userMapper.updateById(user);
        return update;
    }
}
