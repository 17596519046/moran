package com.library.controller;
import com.library.pojo.Equipment;
import com.library.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequestMapping("/equipment")
@Controller
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    /**
     * 修改设备信息
     *
     * @return
     */
    @RequestMapping("/updateEquipment")
    public String updateEquipment(Equipment equipment) {
        // 如果用户id不为0 说明是修改 为0 或者为 null 是新增
        if (equipment.getId() != 0) {
            equipmentService.updateEquipment(equipment);
        } else {
            equipmentService.saveEquipment(equipment);
        }
        return "redirect:equipment";
    }

    /**
     * 删除设备信息
     *
     * @return
     */
    @RequestMapping("/deleteEquipment")
    public String deleteEquipment(Integer id) {
        equipmentService.deleteEquipment(id);
        return "redirect:equipment";
    }

    /**
     * 通过id获取一个用户
     *
     * @return
     */
    @RequestMapping("/getEquipment")
    public String getOneUser(Model model, Integer id) {
        Equipment equipment = equipmentService.selectEquipment(id);
        model.addAttribute("equipment", equipment);
        return "pages/back/equipment-update";
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping("/equipment")
    public String selectEquipmentList(Model model) {
        List<Equipment> equipmentList = equipmentService.selectEquipmentList();
        model.addAttribute("all", equipmentList);
        return "pages/back/equipment";
    }

}
