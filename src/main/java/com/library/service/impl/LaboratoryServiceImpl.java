package com.library.service.impl;
import com.library.mapper.LaboratoryMapper;
import com.library.pojo.Laboratory;
import com.library.pojo.User;
import com.library.pojo.UserLaboratory;
import com.library.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {

    @Autowired
    LaboratoryMapper laboratoryMapper;


    /**
     * 添加实验室信息
     * @param laboratory
     * @return
     */
    @Override
    public boolean saveLaboratory(Laboratory laboratory) {
        return laboratoryMapper.insertLaboratory(laboratory.setCreateTime(new Date()).setUpdateTime(new Date()));
    }

    /**
     * 修改实验室信息
     * @param laboratory
     * @return
     */
    @Override
    public boolean updateLaboratory(Laboratory laboratory) {
        return laboratoryMapper.updateLaboratory(laboratory.setUpdateTime(new Date()));
    }

    /**
     * 查询所有实验室信息
     * @return
     */
    @Override
    public List<Laboratory> selectLaboratoryList() {
        return laboratoryMapper.selectList();
    }

    /***
     * 查询某一实验室信息
     * @param id
     * @return
     */
    @Override
    public Laboratory selectLaboratory(Integer id) {
        return laboratoryMapper.selectLaboratory(id);
    }

    /***
     * 删除实验室
     * @param id
     */
    @Override
    public void deleteLaboratory(Integer id) {
        laboratoryMapper.deleteLaboratory(id);
    }

    @Override
    public List<Laboratory> selectLaboratoryUserInfo() {
        return laboratoryMapper.selectLaboratoryUserInfo(0);
    }

    /**
     * 通过或者拒绝
     */
    @Override
    public void appointmentLaboratory(int state, Integer id, HttpServletRequest request) {
        // 获取当前登录用户信息
        User user = (User) request.getSession().getAttribute("User");
        // 修改预约信息状态
        UserLaboratory laboratory = laboratoryMapper.selectLaboratoryUser(id);
        laboratory.setState(String.valueOf(state));
        laboratory.setAuditId(user.getId());
        laboratoryMapper.updateLaboratoryUser(laboratory);
        // 审核通过 修改实验室表信息
        if (state == 1) {
            Laboratory laboratory1 = laboratoryMapper.selectLaboratory(laboratory.getId());
            laboratory1.setUserId(user.getId());
            laboratory1.setUserName(user.getName());
            laboratory1.setUserNumber(user.getNumber());
            laboratoryMapper.updateLaboratory(laboratory1);
        }
    }

    /**
     * 获取实验室预约情况
     * @param state
     * @return
     */
    @Override
    public List<Laboratory> getlaboratoryappiont(Integer state) {
        List<Laboratory> laboratories = new ArrayList<>();
        if (state == null) {
            laboratories = laboratoryMapper.selectLaboratoryUserInfo1();
        } else {
            laboratories = laboratoryMapper.selectLaboratoryUserInfo(state);
        }
        return laboratories;
    }


}
