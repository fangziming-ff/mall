package com.example.mall.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.NonNull;


/**
 * 用户登录参数
 /**
 * @author Ming
 * @date 2021/12/8 16:37
 */
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NonNull
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NonNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
