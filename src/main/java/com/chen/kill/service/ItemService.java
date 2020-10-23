package com.chen.kill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.kill.entity.ItemEntity;
import com.chen.kill.utils.PageUtils;

import java.util.Map;

/**
 * 商品表
 *
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
public interface ItemService extends IService<ItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

