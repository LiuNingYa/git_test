package com.liuning.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Data
@TableName("yonghuxinxi")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userName;
    private String passWord;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
