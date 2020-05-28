package com.wch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@TableName(value = "s_user")
public class SUser {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String name;
    private String password;
    private String sex;
    private String nickName;
    private int age;
}
