package com.library.service;

import com.library.pojo.Equipment;
import com.library.pojo.User;
import com.library.pojo.UserEquipment;

import java.util.List;
import java.util.Map;

public interface EquipmentService {
    /**
     * 添加设备信息
     * @param equipment
     * @return
     */
    boolean saveEquipment(Equipment equipment);

    /**
     * 设备
     * @param equipment
     * @return
     */
    boolean updateEquipment(Equipment equipment);

    /**
     * 查询所有设备详情
     * @return
     */
    List<Equipment> selectEquipmentList();

    /**
     * 查询设备信息，根据id
     * @return
     */
    Equipment selectEquipment(Integer id);

    /**
     * 删除实验室
     * @param id
     */
    void deleteEquipment(Integer id);

    /***
     * 根据权限查询预约设备基本详情
     * @param userEquipment
     * @return
     */
    List<Map> selectEquipmentUserInfo(UserEquipment userEquipment);

    /***
     * 查询预约设备基本详情
     * @param userEquipment
     * @return
     */
    UserEquipment selectEquipmentUser(UserEquipment userEquipment);

    /***
     * 预约实验室
     * @param userEquipment
     * @return
     */
    boolean insertEquipmentUser(UserEquipment userEquipment);

    /***
     * 修改用户预约实验室基本信息
     * @param userEquipment
     * @return
     */
    boolean updateEquipmentUser(UserEquipment userEquipment,User user);
}
