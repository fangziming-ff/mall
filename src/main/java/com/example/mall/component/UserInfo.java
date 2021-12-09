package com.example.mall.component;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Ming
 * @date 2021/12/9 14:05
 */
public interface UserInfo extends UserDetails {
    String getEmail();
}
