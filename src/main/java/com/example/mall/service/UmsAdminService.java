package com.example.mall.service;




import com.example.mall.mbg.model.UmsAdmin;
import com.example.mall.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员Service
 * @author Ming
 * @date 2021/12/8 16:10
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password,String email);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);
}

