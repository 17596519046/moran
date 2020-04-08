package com.library.service.impl;

import com.library.mapper.EquipmentMapper;
import com.library.pojo.Equipment;
import com.library.pojo.User;
import com.library.pojo.UserEquipment;
import com.library.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentMapper equipmentMapper;


    /**
     * 添加设备信息
     * @param equipment
     * @return
     */
    @Override
    public boolean saveEquipment(Equipment equipment) {
        return equipmentMapper.insertEquipment(equipment.setCreateTime(new Date()).setUpdateTime(new Date()));
    }

    /**
     * 修改设备信息
     * @param equipment
     * @return
     */
    @Override
    public boolean updateEquipment(Equipment equipment) {
        return equipmentMapper.updateEquipment(equipment.setUpdateTime(new Date()));
    }

    /**
     * 查询所有设备信息
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
    public List<Map> selectEquipmentUserInfo(UserEquipment userEquipment) {
        return equipmentMapper.selectEquipmentUserInfo(userEquipment);
    }

    @Override
    public UserEquipment selectEquipmentUser(UserEquipment userEquipment) {
        return equipmentMapper.selectEquipmentUser(userEquipment);
    }

    @Override
    public boolean insertEquipmentUser(UserEquipment userEquipment) {
        Date date = new Date();
        return equipmentMapper.insertEquipmentUser(userEquipment.setAppointTime(date).setState(1));
    }

    @Override
    public boolean updateEquipmentUser(UserEquipment userEquipment, User user) {
        if(userEquipment.getState() == 1 || userEquipment.getState() == 2){
            userEquipment.setAuditId(user.getId());
        }
        return equipmentMapper.updateEquipmentUser(userEquipment);
    }


}
