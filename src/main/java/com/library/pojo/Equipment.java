package com.library.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
    * equipment 瀹炰綋绫籠r
    * 2020-04-06 14:47:03
   */
@Data
@Accessors(chain = true)
public class Equipment{
	/**
	*主键id
	*/
	private Integer	id;
	/**
	*设备名称
	*/
	private String	name;
	/**
	*购入时间
	*/
	private String buyTime;
	/**
	*编号
	*/
	private String	number;
	/**
	*销毁时间
	*/
	private Date destoryTime;
	/**
	*创建时间
	*/
	private Date createTime;
	/**
	*修改时间
	*/
	private Date updateTime;
	/**
	*0:未预约，1：已预约
	*/
	private int	isAppointment;

	/**
	 * 使用人
	 */
	private String userName;
	/**
	 * 使用人工号
	 */
	private String userNumber;
	private String userPhone;

	private Integer userId;

	private String createTime1;

	private int state;

	private String appointTime;

	/**
	 * 归还时间
	 */
	private String returnTime;

	private String code;

}
