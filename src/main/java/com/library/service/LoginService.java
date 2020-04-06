package com.library.service;
import com.library.pojo.*;
import com.library.vo.BuyCarInfo;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginService {

    int selectUserInfo(SystemUser systemUser);

    SystemUser selectInfo(SystemUser systemUser);

    int insertEvaluate(EvaluateInner evaluateInner);

    List<EvaluateInnerVO> selectListEvaluate(EvaluateInner evaluateInner);

    int cancelOrder(SystemUser systemUser);

    int insertInfo(SystemUser systemUser);

    int insertAddressInfo(AddressInfo addressInfo);

    int updateAddressInfo(AddressInfo addressInfo);

    int deleteAddressInfo(AddressInfo addressInfo);

    List<AddressInfo> selectListAddressInfo(int id);

    AddressInfo selectAddressInfo(AddressInfo addressInfo);

    AddressInfo selectAddressMyselfInfo(AddressInfo addressInfo);

    int updateInfo(SystemUser systemUser);

    int updatePasswordInfo(SystemUser systemUser);

    List<Goods> selectAllGoods(Goods goods);

    List<Goods> selectAllArea();

    int insertBuyCar(BuyCar buyCar);

    List<BuyCarInfo> selectBuyCarInfo(BuyCar buyCar);

    List<OrderGoods> selectOrderGoods(OrderInfo orderInfo);

    List<BuyCarInfo> selectOrderInfo(BuyCar buyCar);

    String selectAllPrice(List<BuyCarInfo> list);

    int deleteBuyCar(int id);

    int settleOrderInfo(OrderInfo orderInfo, HttpServletRequest request);

}
