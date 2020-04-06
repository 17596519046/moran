package com.library.mapper;
import com.library.pojo.Equipment;
import java.util.List;

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
}
