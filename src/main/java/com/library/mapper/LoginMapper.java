package com.library.mapper;
import com.library.pojo.*;
import com.library.vo.BuyCarInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {

    int insertEvaluate(EvaluateInner evaluateInner);

    List<EvaluateInnerVO> selectEvaluate(EvaluateInner evaluateInner);

    int cancelOrder(SystemUser systemUser);

    int selectUserInfo(SystemUser systemUser);

    SystemUser selectInfo(SystemUser systemUser);

    int insertInfo(SystemUser systemUser);

    int insertAddressInfo(AddressInfo addressInfo);

    int updateAddressInfo(AddressInfo addressInfo);

    int updateDefaultAddress(AddressInfo addressInfo);

    int deleteAddressInfo(AddressInfo addressInfo);

    List<AddressInfo> selectListAddress(int id);

    AddressInfo selectAddressInfo(AddressInfo addressInfo);

    AddressInfo selectAddressMyself(AddressInfo addressInfo);

    int updatePasswordInfo(SystemUser systemUser);

    List<Goods> selectAllGoodsInfo(Goods goods);

    List<Goods> selectCityInfo();

    int updateMyself(SystemUser systemUser);

    int insertBuyCar(BuyCar buyCar);

    List<BuyCarInfo> selectBuyCarInfo(BuyCar buyCar);

    List<BuyCarInfo> selectOrderInfo(BuyCar buyCar);

    List<OrderGoods> selectOrderGoodsInfo(OrderInfo orderInfo);

    int deleteBuyCar(int id);

    int insertOrderInfo(OrderInfo orderInfo);

    int updateBatchList(@Param(value = "list") List<BuyCarInfo> buyCars);
}
