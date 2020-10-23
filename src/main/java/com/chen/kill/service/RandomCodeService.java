package com.chen.kill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.kill.entity.RandomCodeEntity;
import com.chen.kill.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
public interface RandomCodeService extends IService<RandomCodeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

