package com.library.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
    * user_equipment 实体类\r
    * 2020-04-06 14:48:26
   */ 
@Data
@Accessors(chain = true)
public class UserEquipment{
	/**
	*����id
	*/
	private int	id;
	/**
	*ԤԼ���
	*/
	private String	code;
	/**
	*�豸id
	*/
	private int	equipmentId;
	/**
	*ԤԼʱ��
	*/
	private Date appointTime;
	/**
	*�黹ʱ��
	*/
	private Date	returnTime;
	/**
	*ԤԼ��
	*/
	private int	userId;
	/**
	*�����
	*/
	private int	auditId;
	/**
	*����ʱ��
	*/
	private Date	overdueTime;
	/**
	*0:����ԤԼ��,1:���ͨ����2�����ʧ�ܣ�3���ѹ黹��4��������
	*/
	private int	state;
}
