package com.library.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
    * user_laboratory 瀹炰綋绫籠r
    * 2020-04-06 14:49:08
   */
@Data
@Accessors(chain = true)
public class UserLaboratory{
	/**
	*主键id
	*/
	private int	id;
	/**
	*预约编号
	*/
	private String	code;
	/**
	*预约人id
	*/
	private int	userId;
	/**
	*实验室id
	*/
	private int	laboratoryId;
	/**
	*预约时间
	*/
	private Date appointTime;
	/**
	*归还时间
	*/
	private String	returnTime;
	/**
	*逾期时间
	*/
	private Date	overdueTime;
	/**
	*审核人
	*/
	private int	auditId;
	//state
	private String	state;
	/**
	*创建时间
	*/
	private Date	createTime;
}
