package com.liuning.service;

import com.liuning.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    public List<User> selectAll();
}
