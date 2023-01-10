package com.liuning.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuning.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    public List<User> selectAll();
}
