package com.library.service;

import com.library.pojo.Equipment;

import java.util.List;

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
}
