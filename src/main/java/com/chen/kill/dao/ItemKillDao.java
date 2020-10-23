package com.chen.kill.dao;

import com.chen.kill.entity.ItemKillEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 待秒杀商品表
 * 
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
@Mapper
public interface ItemKillDao extends BaseMapper<ItemKillEntity> {
	
}
