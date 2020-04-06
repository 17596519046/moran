package com.library.pojo;

import lombok.Data;

import java.util.Date;

/**
    * evaluate_inner ʵ����
    * 2020-03-25 22:43:00
   */
@Data
public class EvaluateInner{
	/**
	*����id
	*/
	private int	id;
	/**
	*��������
	*/
	private String innerRemark;
	/**
	*��Ʒid
	*/
	private int	goodsId;
	/**
	*�û�id
	*/
	private int	userId;
	/**
	*����ʱ��
	*/
	private Date createTime;
	/**
	*����ʱ��
	*/
	private Date updateTime;
}
