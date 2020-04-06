package com.library.controller;
import com.library.pojo.Laboratory;
import com.library.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        // 如果用户id不为0 说明是修改 为0 或者为 null 是新增
        if (laboratory.getId() != 0) {
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

}
