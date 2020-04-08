package com.library.mapper;
import com.library.pojo.Equipment;
import com.library.pojo.UserEquipment;

import java.util.List;
import java.util.Map;

public interface EquipmentMapper {

    /**
     * 添加设备信息
     * @param equipment
     * @return
     */
    boolean insertEquipment(Equipment equipment);

    /**
     * 修改设备信息
     * @param equipment
     * @return
     */
    boolean updateEquipment(Equipment equipment);

    /**
     * 查询所有设备信息
     * @return
     */
    List<Equipment> selectList();

    /**
     * 查询设备详情,根据id
     * @return
     */
    Equipment selectEquipment(Integer id);

    /**
     * 删除设备信息
     * @param id
     */
    void deleteEquipment(Integer id);

    /***
     * 修改用户预约设备详情
     * @param userEquipment
     * @return
     */
    boolean updateEquipmentUser(UserEquipment userEquipment);

    /***
     * 查询预约设备详情
     * @param userEquipment
     * @return
     */
    UserEquipment selectEquipmentUser(UserEquipment userEquipment);

    /***
     * 根据用户权限，查询设备预约详情
     * @param userEquipment
     * @return
     */
    List<Map> selectEquipmentUserInfo(UserEquipment userEquipment);

    /***
     * 预约设备
     * @param userEquipment
     * @return
     */
    boolean insertEquipmentUser(UserEquipment userEquipment);
}
