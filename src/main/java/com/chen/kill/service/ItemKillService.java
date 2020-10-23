package com.chen.kill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.kill.entity.ItemKillEntity;
import com.chen.kill.utils.PageUtils;

import java.util.Map;

/**
 * 待秒杀商品表
 *
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
public interface ItemKillService extends IService<ItemKillEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Boolean kill(String id) throws InterruptedException;
}

