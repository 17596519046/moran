package com.library.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
    * user 实体类
    * 2020-04-06 14:44:56
   */ 
@Data
@Accessors(chain = true)
public class User{
	/**
	*主键id
	*/
	private int	id;
	/**
	*1：超管，2：老师，3：学生，4：后勤
	*/
	private int	role;
	/**
	*姓名
	*/
	private String	name;
	/**
	*工号
	*/
	private String	number;
	/**
	*班级
	*/
	private String	grade;
	/**
	*手机号
	*/
	private String	phone;
	/**
	*入学时间
	*/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date entranceTime;
	/**
	*毕业时间
	*/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date graduateTime;
	/**
	*创建时间
	*/
	protected Date createTime;
	/**
	*更新时间
	*/
	protected Date updateTime;
}
