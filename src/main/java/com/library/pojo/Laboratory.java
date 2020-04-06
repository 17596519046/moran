package com.library.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
    * laboratory ʵ����
    * 2020-04-06 14:46:11
   */ 
@Data
@Accessors(chain = true)
public class Laboratory{
	/**
	*����id
	*/
	private int	id;
	/**
	*ʵ��������
	*/
	private String	name;
	/**
	*¥��
	*/
	private String	buildingNo;
	/**
	*����ʱ��
	*/
	private Date createTime;
	/**
	*����ʱ��
	*/
	private Date updateTime;
	/**
	*�Ƿ�ԤԼ��0��δԤԼ��1����ԤԼ��
	*/
	private int	isAppointment;
}
