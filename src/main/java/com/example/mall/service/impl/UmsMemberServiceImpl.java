package com.example.mall.service.impl;

import com.example.mall.common.api.CommonResult;
import com.example.mall.service.RedisService;
import com.example.mall.service.UmsMemberService;
import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * 会员管理Service实现类
 *
 * @author Ming
 * @date 2021/12/8 14:55
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisServiceImpl redisService;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set("register" + telephone, sb.toString(), 120);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }


    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get("register" + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            redisService.remove("register" + telephone);
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }

}

