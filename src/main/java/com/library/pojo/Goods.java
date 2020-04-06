package com.library.pojo;

import lombok.Data;

/**
    * goods 实体类
    * 2020-03-12 15:19:09
   */
@Data
public class Goods{
	//id
	private int	id;
	/**
	*商品名称
	*/
	private String	name;
	/**
	*商品价格
	*/
	private String	price;
	/**
	*商品详情
	*/
	private String	detail;
	/**
	*城市
	*/
	private String	area;
	/**
	*库存数量
	*/
	private int	num;
	/**
	*商品图片地址
	*/
	private String	img;
	/**
	*创建时间
	*/
	private String	createTime;
	/**
	*修改时间
	*/
	private String	updateTime;
}
