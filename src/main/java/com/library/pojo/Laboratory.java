package com.library.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * laboratory 实体类
 * 2020-04-06 14:46:11
 */
@Data
@Accessors(chain = true)
public class Laboratory {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 实验室名称
     */
    private String name;
    /**
     * 楼号
     */
    private String buildingNo;
    /**
     * 使用人
     */
    private String userName;
    private String userPhone;

    /**
     * 使用人工号
     */
    private String userNumber;

    private Integer userId;
    /**
     * 创建时间
     */
    private Date createTime;
    private String createTime1;

    private int state;

    private String appointTime;

    /**
     * 归还时间
     */
    private String returnTime;

    private String code;

    /**
     * 更改时间
     */
    private Date updateTime;
    /**
     * 是否预约（0：未预约，1：已预约）
     */
    private int isAppointment;

}
