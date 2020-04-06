package com.library.mapper;

import com.library.pojo.Equipment;
import com.library.pojo.Laboratory;

import java.util.List;

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
