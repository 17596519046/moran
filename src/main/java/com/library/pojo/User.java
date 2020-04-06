package com.library.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
    * user ʵ����
    * 2020-04-06 14:44:56
   */ 
@Data
@Accessors(chain = true)
public class User{
	/**
	*����id
	*/
	private int	id;
	/**
	*1�����ܣ�2����ʦ��3��ѧ����4������
	*/
	private int	role;
	/**
	*����
	*/
	private String	name;
	/**
	*����
	*/
	private String	number;
	/**
	*�༶
	*/
	private String	grade;
	/**
	*�ֻ���
	*/
	private String	phone;
	/**
	*��ѧʱ��
	*/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date entranceTime;
	/**
	*��ҵʱ��
	*/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date graduateTime;
	/**
	*����ʱ��
	*/
	protected Date createTime;
	/**
	*����ʱ��
	*/
	protected Date updateTime;
}
