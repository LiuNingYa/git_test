package com.liuning.service.impl;

import com.liuning.pojo.User;
import com.liuning.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapperIpml implements UserMapper {

    @Autowired
    private com.liuning.mapper.UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectList(null);
    }
}
