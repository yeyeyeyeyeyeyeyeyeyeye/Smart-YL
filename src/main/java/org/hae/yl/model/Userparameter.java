package org.hae.yl.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Userparameter{
    private String        username;            //用户ID
    private String        password;            //密码
    private String        real_name;           //昵称
    private String        phone;               //绑定手机号
    private String        avatar;              //头像链接
    private int           role_id;             //角色Id
    private int           status;              //账户状态信息
    private LocalDateTime created_at;          //创建时间
}
