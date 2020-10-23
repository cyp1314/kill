package com.chen.kill.dao;

import com.chen.kill.entity.ItemKillSuccessEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀成功订单表
 * 
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
@Mapper
public interface ItemKillSuccessDao extends BaseMapper<ItemKillSuccessEntity> {
	
}
