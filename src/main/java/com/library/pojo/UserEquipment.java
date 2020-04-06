package com.library.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
    * user_equipment 瀹炰綋绫籠r
    * 2020-04-06 14:48:26
   */ 
@Data
@Accessors(chain = true)
public class UserEquipment{
	/**
	*主键id
	*/
	private int	id;
	/**
	*预约编号
	*/
	private String	code;
	/**
	*设备id
	*/
	private int	equipmentId;
	/**
	*预约时间
	*/
	private Date appointTime;
	/**
	*归还时间
	*/
	private Date	returnTime;
	/**
	*预约人
	*/
	private int	userId;
	/**
	*审核人
	*/
	private int	auditId;
	/**
	*逾期时间
	*/
	private Date	overdueTime;
	/**
	*0:生成预约单,1:审核通过，2：审核失败，3：已归还，4：已逾期
	*/
	private int	state;
}
