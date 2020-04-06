package com.library.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
    * equipment 实体类\r
    * 2020-04-06 14:47:03
   */ 
@Data
@Accessors(chain = true)
public class Equipment{
	/**
	*����id
	*/
	private int	id;
	/**
	*�豸����
	*/
	private String	name;
	/**
	*����ʱ��
	*/
	private Date buyTime;
	/**
	*���
	*/
	private String	number;
	/**
	*����ʱ��
	*/
	private Date destoryTime;
	/**
	*����ʱ��
	*/
	private Date createTime;
	/**
	*�޸�ʱ��
	*/
	private Date updateTime;
	/**
	*0:δԤԼ��1����ԤԼ
	*/
	private int	isAppointment;
}
