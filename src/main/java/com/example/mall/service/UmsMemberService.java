package com.example.mall.service;


import com.example.mall.common.api.CommonResult;

/**
 * 会员管理Service
 *
 * @author Ming
 * @date 2021/12/8 14:53
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}

