package com.library.service.impl;
import com.library.mapper.LaboratoryMapper;
import com.library.pojo.Laboratory;
import com.library.pojo.User;
import com.library.pojo.UserLaboratory;
import com.library.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public List<Map> selectLaboratoryUserInfo(UserLaboratory userLaboratory) {
        return laboratoryMapper.selectLaboratoryUserInfo(userLaboratory);
    }

    @Override
    public UserLaboratory selectLaboratoryUser(UserLaboratory userLaboratory) {
        return laboratoryMapper.selectLaboratoryUser(userLaboratory);
    }

    @Override
    public boolean insertLaboratoryUser(UserLaboratory userLaboratory) {
        Date date = new Date();
        return laboratoryMapper.insertLaboratoryUser(userLaboratory
        .setCreateTime(date).setAppointTime(date).setState("0"));
    }

    @Override
    public boolean updateLaboratoryUser(UserLaboratory userLaboratory,User user) {
        if(userLaboratory.getState().equals("1") || userLaboratory.getState().equals("2")){
            userLaboratory.setAuditId(user.getId());
        }
        return laboratoryMapper.updateLaboratoryUser(userLaboratory);
    }


}
