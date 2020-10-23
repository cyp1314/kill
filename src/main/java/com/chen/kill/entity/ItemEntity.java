package com.chen.kill.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品表
 * 
 * @author cyp
 * @email yongpeng.chen@hcr.com.cn
 * @date 2020-10-22 11:28:15
 */
@Data
@TableName("item")
public class ItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 商品名
	 */
	private String name;
	/**
	 * 商品编号
	 */
	private String code;
	/**
	 * 库存
	 */
	private Long stock;
	/**
	 * 采购时间
	 */
	private Date purchaseTime;
	/**
	 * 是否有效（1=是；0=否）
	 */
	private Integer isActive;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
