package com.library.mapper;

import com.library.pojo.Goods;
import com.library.vo.OrderInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈描述：mapper〉
 *
 * @author zzy
 * @create 2020/3/14
 * @since 1.0.0
 */
public interface OrderMapper {

    List<OrderInfoVO> getAllOrder(int isAll);

    void updateStatus(@Param("orderId") Integer orderId, @Param("orderStatus") Integer orderStatus);

    List<OrderInfoVO> getAllOrder1();

    OrderInfoVO getOneOrder(Integer orderId);

    void updateGoodsNum(@Param("gsId") int gsId, @Param("num") Integer num);

    List<Goods> getAllGoods();

    void addGoods(Goods goods);

    void deleteGoods(Integer goodsId);

    void updateGoods(Goods goods);

    List<Goods> getAllGoods1(String name);
}
