package com.example.mall.dto;

import com.example.mall.component.UserInfo;
import com.example.mall.mbg.model.UmsAdmin;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Ming
 * @date 2021/12/9 14:11
 */
public class UserInfoDetails implements UserInfo {
    private UmsAdmin umsAdmin;

    public UserInfoDetails(UmsAdmin umsAdmin){
        this.umsAdmin=umsAdmin;
    }
    @Override
    public String getEmail() {
        return umsAdmin.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
