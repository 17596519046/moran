package com.library.service;

import com.library.pojo.Equipment;
import com.library.pojo.User;
import com.library.pojo.UserEquipment;

import javax.servlet.http.HttpServletRequest;
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
     * @return
     */
    List<Equipment> selectEquipmentUserInfo();

    void insertUserEquipment(HttpServletRequest request, int id, String retrurnTime);

    void appointmentEquipment(int state, Integer id, HttpServletRequest request);

    List<Equipment> getEquipmentappiont(Integer state);

    List<Equipment> getMyEquipment(HttpServletRequest request);

    void returnEquipment(HttpServletRequest request, int id);
}
