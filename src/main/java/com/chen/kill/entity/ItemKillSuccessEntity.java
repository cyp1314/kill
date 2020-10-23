package com.chen.kill.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 秒杀成功订单表
 * 
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
@Data
@TableName("item_kill_success")
public class ItemKillSuccessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 秒杀成功生成的订单编号
	 */
	@TableId
	private String code;
	/**
	 * 商品id
	 */
	private Integer itemId;
	/**
	 * 秒杀id
	 */
	private Integer killId;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 秒杀结果: -1无效  0成功(未付款)  1已付款  2已取消
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
