package com.chen.kill.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 待秒杀商品表
 * 
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
@Data
@TableName("item_kill")
public class ItemKillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Integer id;
	/**
	 * 商品id
	 */
	private Integer itemId;
	/**
	 * 可被秒杀的总数
	 */
	private Integer total;
	/**
	 * 秒杀开始时间
	 */
	private Date startTime;
	/**
	 * 秒杀结束时间
	 */
	private Date endTime;
	/**
	 * 是否有效（1=是；0=否）
	 */
	private Integer isActive;
	/**
	 * 创建的时间
	 */
	private Date createTime;

}
