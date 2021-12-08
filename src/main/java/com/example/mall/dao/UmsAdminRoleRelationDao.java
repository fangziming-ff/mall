package com.example.mall.dao;

import com.example.mall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ming
 * @date 2021/12/8 16:40
 */
@Repository
public interface UmsAdminRoleRelationDao {
    List<UmsPermission> getPermissionList(@Param("adminId")Long adminId);
}
