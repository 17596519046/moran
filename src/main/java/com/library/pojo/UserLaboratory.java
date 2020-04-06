package com.library.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
    * user_laboratory 实体类\r
    * 2020-04-06 14:49:08
   */ 
@Data
@Accessors(chain = true)
public class UserLaboratory{
	/**
	*����id
	*/
	private int	id;
	/**
	*ԤԼ���
	*/
	private String	code;
	/**
	*ԤԼ��id
	*/
	private int	userId;
	/**
	*ʵ����id
	*/
	private int	laboratoryId;
	/**
	*ԤԼʱ��
	*/
	private Date appointTime;
	/**
	*�黹ʱ��
	*/
	private Date	returnTime;
	/**
	*����ʱ��
	*/
	private Date	overdueTime;
	/**
	*�����
	*/
	private int	auditId;
	//state
	private String	state;
	/**
	*����ʱ��
	*/
	private Date	createTime;
}
