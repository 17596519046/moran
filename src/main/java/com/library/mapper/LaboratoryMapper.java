package com.library.mapper;

import com.library.pojo.Equipment;
import com.library.pojo.Laboratory;
import com.library.pojo.UserEquipment;
import com.library.pojo.UserLaboratory;

import java.util.List;
import java.util.Map;

public interface LaboratoryMapper {

    /**
     * 添加实验室信息
     * @param laboratory
     * @return
     */
    boolean insertLaboratory(Laboratory laboratory);

    /**
     * 修改实验室信息
     * @param laboratory
     * @return
     */
    boolean updateLaboratory(Laboratory laboratory);

    /***
     * 预约实验室
     * @param userLaboratory
     * @return
     */
    boolean insertLaboratoryUser(UserLaboratory userLaboratory);

    /***
     * 修改预约实验室基本信息
     * @param userLaboratory
     * @return
     */
    boolean updateLaboratoryUser(UserLaboratory userLaboratory);

    /****
     * 查询预约实验室详情
     * @return
     */
    UserLaboratory selectLaboratoryUser(UserLaboratory userLaboratory);

    /***
     * 根据用户权限，查询实验室预约详情
     * @param laboratory
     * @return
     */
    List<Map> selectLaboratoryUserInfo(UserLaboratory laboratory);


    /**
     * 查询所有实验室信息
     * @return
     */
    List<Laboratory> selectList();

    /**
     * 查询实验室详情,根据id
     * @return
     */
    Laboratory selectLaboratory(Integer id);

    /**
     * 删除实验室信息
     * @param id
     */
    void deleteLaboratory(Integer id);
}
