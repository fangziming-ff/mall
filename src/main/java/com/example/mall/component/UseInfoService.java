package com.example.mall.component;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Ming
 * @date 2021/12/9 14:07
 */
public interface UseInfoService extends UserDetailsService {

    /**查询用户信息
     * @param var1
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    UserInfo loadUserByUsername(String var1) throws UsernameNotFoundException;
}
