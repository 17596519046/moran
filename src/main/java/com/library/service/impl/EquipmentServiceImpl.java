package com.library.service.impl;

import com.library.mapper.EquipmentMapper;
import com.library.pojo.*;
import com.library.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentMapper equipmentMapper;


    /**
     * 添加设备信息
     *
     * @param equipment
     * @return
     */
    @Override
    public boolean saveEquipment(Equipment equipment) {
        return equipmentMapper.insertEquipment(equipment.setCreateTime(new Date()).setUpdateTime(new Date()).setIsAppointment(0));
    }

    /**
     * 修改设备信息
     *
     * @param equipment
     * @return
     */
    @Override
    public boolean updateEquipment(Equipment equipment) {
        return equipmentMapper.updateEquipment(equipment.setUpdateTime(new Date()));
    }

    /**
     * 查询所有设备信息
     *
     * @return
     */
    @Override
    public List<Equipment> selectEquipmentList() {
        return equipmentMapper.selectList();
    }

    /***
     * 查询某一设备信息
     * @param id
     * @return
     */
    @Override
    public Equipment selectEquipment(Integer id) {
        return equipmentMapper.selectEquipment(id);
    }

    /***
     * 删除实验室
     * @param id
     */
    @Override
    public void deleteEquipment(Integer id) {
        equipmentMapper.deleteEquipment(id);
    }

    @Override
    public List<Equipment> selectEquipmentUserInfo() {
        return equipmentMapper.selectLaboratoryUserInfo(0);
    }

    @Override
    public void insertUserEquipment(HttpServletRequest request, int id) {
        // 获取当前登录用户信息
        User user = (User) request.getSession().getAttribute("User");
        UserEquipment userEquipment = new UserEquipment();
        userEquipment.setState(0);
        String s = String.valueOf(System.currentTimeMillis()).substring(0, 8) + id;
        userEquipment.setCode(s);
        userEquipment.setUserId(user.getId());
        userEquipment.setEquipmentId(id);
        userEquipment.setAppointTime(new Date());
        userEquipment.setReturnTime(new Date());
        equipmentMapper.insertEquipmentUser(userEquipment);
        Equipment equipment = equipmentMapper.selectEquipment(userEquipment.getEquipmentId());
        equipment.setIsAppointment(1);
        equipmentMapper.updateEquipment(equipment);

    }

    @Override
    public void appointmentEquipment(int state, Integer id, HttpServletRequest request) {
        // 获取当前登录用户信息
        User user = (User) request.getSession().getAttribute("User");
        // 修改预约信息状态
        UserEquipment userEquipment = equipmentMapper.selectEquipmentUser(id);
        userEquipment.setState(state);
        userEquipment.setAuditId(user.getId());
        equipmentMapper.updateEquipmentUser(userEquipment);
        // 审核通过 修改实验室表信息
        if (state == 1) {
            Equipment laboratory1 = equipmentMapper.selectEquipment(userEquipment.getEquipmentId());
            laboratory1.setUserId(user.getId());
            laboratory1.setUserName(user.getName());
            laboratory1.setUserNumber(user.getNumber());
            laboratory1.setIsAppointment(2);
            equipmentMapper.updateEquipment(laboratory1);
        }
    }

    @Override
    public List<Equipment> getEquipmentappiont(Integer state) {
        List<Equipment> equipments = new ArrayList<>();
        if (state == null) {
            equipments = equipmentMapper.selectLaboratoryUserInfo1();
        } else {
            equipments = equipmentMapper.selectLaboratoryUserInfo(state);
        }
        return equipments;
    }

    @Override
    public List<Equipment> getMyEquipment(HttpServletRequest request) {
        // 获取当前登录用户信息
        User user = (User) request.getSession().getAttribute("User");
        // 获取当前登录用户预约的实验室
        List<Equipment> equipmentList = equipmentMapper.getMyEquipment(user.getId());
        return equipmentList;
    }


}
