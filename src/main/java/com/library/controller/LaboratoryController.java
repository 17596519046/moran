package com.library.controller;
import com.library.pojo.Laboratory;
import com.library.pojo.User;
import com.library.pojo.UserLaboratory;
import com.library.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequestMapping("/laboratory")
@Controller
public class LaboratoryController {

    @Autowired
    LaboratoryService laboratoryService;

    /**
     * 修改实验室信息
     *laboratory
     * @return
     */
    @RequestMapping("/updateLaboratory")
    public String updateLaboratory(Laboratory laboratory) {
        if (laboratory.getId() != 0) {
            laboratoryService.updateLaboratory(laboratory);
        } else {
            laboratoryService.saveLaboratory(laboratory);
        }
        return "redirect:laboratory";
    }

    /**
     * 预约实验室/修改预约实验室的信息
     *laboratory
     * @return
     */
    @RequestMapping("/updateLaboratoryUser")
    public String updateLaboratoryUser(UserLaboratory userLaboratory, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("systemUser");
        if (userLaboratory.getId() != 0) {
            laboratoryService.updateLaboratoryUser(userLaboratory,user);
        } else {
            userLaboratory.setAuditId(user.getId());
            laboratoryService.insertLaboratoryUser(userLaboratory);
        }
        return "redirect:selectLaboratoryUserInfo";
    }

    /**
     * 删除实验室信息
     *
     * @return
     */
    @RequestMapping("/deleteLaboratory")
    public String deleteLaboratory(Integer id) {
        laboratoryService.deleteLaboratory(id);
        return "redirect:laboratory";
    }

    /**
     * 通过id获取一个用户
     *
     * @return
     */
    @RequestMapping("/getLaboratory")
    public String getLaboratory(Model model, Integer id) {
        Laboratory laboratory = laboratoryService.selectLaboratory(id);
        model.addAttribute("laboratory", laboratory);
        return "pages/back/laboratory-update";
    }

    /**
     * 查询所有实验室
     *
     * @return
     */
    @RequestMapping("/laboratory")
    public String selectEquipmentList(Model model) {
        List<Laboratory> laboratoryList = laboratoryService.selectLaboratoryList();
        model.addAttribute("all", laboratoryList);
        return "pages/back/laboratory";
    }

    /**
     * 根据用户权限查询预约实验室基本信息
     *
     * @return
     */
    @RequestMapping("/selectLaboratoryUserInfo")
    public String selectLaboratoryUserInfo(Model model, UserLaboratory userLaboratory) {
        List<Map> laboratoryList = laboratoryService.selectLaboratoryUserInfo(userLaboratory);
        model.addAttribute("laboratoryList", laboratoryList);
        return "pages/back/laboratory";
    }

    /**
     * 根据预约实验室详情
     *
     * @return
     */
    @RequestMapping("/selectLaboratoryUser")
    public String selectLaboratoryUser(Model model, UserLaboratory userLaboratory) {
        UserLaboratory laboratoryUser = laboratoryService.selectLaboratoryUser(userLaboratory);
        model.addAttribute("laboratoryUser", laboratoryUser);
        return "pages/back/laboratory";
    }

}
