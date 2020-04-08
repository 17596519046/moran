package com.library.service;

import com.library.pojo.Laboratory;
import com.library.pojo.User;
import com.library.pojo.UserLaboratory;

import java.util.List;
import java.util.Map;

public interface LaboratoryService {
    /**
     * 添加实验室信息
     * @param laboratory
     * @return
     */
    boolean saveLaboratory(Laboratory laboratory);

    /**
     * 修改实验室信息
     * @param laboratory
     * @return
     */
    boolean updateLaboratory(Laboratory laboratory);

    /**
     * 查询所有实验室详情
     * @return
     */
    List<Laboratory> selectLaboratoryList();

    /**
     * 查询实验室信息，根据id
     * @return
     */
    Laboratory selectLaboratory(Integer id);

    /**
     * 删除实验室
     * @param id
     */
    void deleteLaboratory(Integer id);

    List<Map> selectLaboratoryUserInfo(UserLaboratory userLaboratory);

    UserLaboratory selectLaboratoryUser(UserLaboratory userLaboratory);

    boolean insertLaboratoryUser(UserLaboratory userLaboratory);

    boolean updateLaboratoryUser(UserLaboratory userLaboratory, User user);
}
