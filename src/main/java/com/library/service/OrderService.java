package com.library.service;

import com.library.pojo.Goods;
import com.library.vo.OrderInfoVO;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈描述：service〉
 *
 * @author zzy
 * @create 2020/3/14
 * @since 1.0.0
 */
public interface OrderService {

    List<OrderInfoVO> getAllOrder(int isAll);

    void updateStatus(Integer orderId, Integer orderStatus);

    List<Goods> getAllGoods(String name);

    void addGoods(Goods goods);

    void deleteGoods(Integer goodsId);

    void updateGoods(Goods goods);
}
