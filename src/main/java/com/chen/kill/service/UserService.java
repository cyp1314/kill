package com.chen.kill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.kill.entity.UserEntity;
import com.chen.kill.utils.PageUtils;

import java.util.Map;

/**
 * 用户信息表
 *
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

