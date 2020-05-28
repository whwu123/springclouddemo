package com.wch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@TableName(value="client_user")
public class ClientUser {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String userName;
    private String userPwd;

}
