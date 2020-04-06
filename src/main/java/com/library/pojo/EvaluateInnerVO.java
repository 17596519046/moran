package com.library.pojo;

import lombok.Data;

import java.util.Date;

/**
    * evaluate_inner ʵ����
    * 2020-03-25 22:43:00
   */
@Data
public class EvaluateInnerVO {
	/**
	*����id
	*/
	private int	id;
	/**
	*��������
	*/
	private String innerRemark;
	/**
	*�û�����
	*/
	private String userName;
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
