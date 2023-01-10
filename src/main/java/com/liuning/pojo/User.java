package com.liuning.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@TableName("yonghuxinxi")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userName;
    private String passWord;
}
