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
import javax.swing.plaf.nimbus.State;
import java.util.List;
import java.util.Map;

@RequestMapping("/laboratory")
@Controller
public class LaboratoryController {

    @Autowired
    LaboratoryService laboratoryService;

    /**
     * 修改添加实验室信息
     * laboratory
     *
     * @return
     */
    @RequestMapping("/updateLaboratory")
    public String updateLaboratory(Laboratory laboratory) {
        if (laboratory.getId() != null && laboratory.getId() != 0) {
            laboratoryService.updateLaboratory(laboratory);
        } else {
            laboratoryService.saveLaboratory(laboratory);
        }
        return "redirect:laboratory";
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
     * 查询所有实验室
     *
     * @return
     */
    @RequestMapping("/laboratory")
    public String selectEquipmentList(Model model) {
        List<Laboratory> laboratoryList = laboratoryService.selectLaboratoryList();
        model.addAttribute("all", laboratoryList);
        return "static/pages/back/laboratory";
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
        return "static/pages/back/laboratoryinsert";
    }

    /**
     * 查询预约实验室的信息
     */
    @RequestMapping("/selectLaboratoryUserInfo")
    public String selectLaboratoryUserInfo(Model model) {
        List<Laboratory> laboratoryList = laboratoryService.selectLaboratoryUserInfo();
        model.addAttribute("laboratoryList", laboratoryList);
        return "static/pages/back/laboratoryexamine";
    }

    /**
     * 通过或者拒绝设备
     */
    @RequestMapping("/appointmentLaboratory")
    public String appointmentLaboratory(int state, Integer id, HttpServletRequest request) {
        laboratoryService.appointmentLaboratory(state, id, request);
        return "redirect: selectLaboratoryUserInfo";
    }

    /**
     * 预约详情
     *
     * @return
     */
    @RequestMapping("/getlaboratoryappiont")
    public String getlaboratoryappiont(Model model, Integer state) {
        List<Laboratory> laboratoryList = laboratoryService.getlaboratoryappiont(state);
        model.addAttribute("all", laboratoryList);
        return "static/pages/back/laboratoryappiont";
    }
    /**
     * 我预约的实验室
     *
     * @return
     */
    @RequestMapping("/getMylaboratory")
    public String getMylaboratory(Model model, HttpServletRequest request) {
        List<Laboratory> laboratoryList = laboratoryService.getMylaboratory(request);
        model.addAttribute("all", laboratoryList);
        return "static/pages/back/laboratoryappiont";
    }

    /**
     * 预约按钮
     *
     * @return
     */
    @RequestMapping("/insertUserLaboratory")
    public String insertUserLaboratory(Model model, HttpServletRequest request, int id) {
        laboratoryService.insertUserLaboratory(request, id);
        return "redirect: laboratory";
    }

}















