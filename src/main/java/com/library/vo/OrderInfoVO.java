package com.library.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈描述：vo〉
 *
 * @author zzy
 * @create 2020/3/28
 * @since 1.0.0
 */
@Data
public class OrderInfoVO {

    private int id;

    /**
     *商品名称
     */
    private String	name;
    /**
     *客户名称
     */
    private String	username;
    /**
     *客户手机号
     */
    private String	receivePhone;
    /**
     *商品价格
     */
    private String	price;
    /**
     *商品详情
     */
    private String	detail;
    /**
     *商品图片地址
     */
    private String img;
    /**
     *下单时间
     */
    @JsonFormat(timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private String	cretateTime;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 订单状态
     */
    private int orderStatus;
    /**
     * 订单状态
     */
    private String orderStatusStr;

    /**
     * 下单地址
     */
    private String address;

    private int gsId;

}






















