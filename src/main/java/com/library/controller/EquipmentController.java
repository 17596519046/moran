package com.library.controller;
import com.library.pojo.Equipment;
import com.library.pojo.User;
import com.library.pojo.UserEquipment;
import com.library.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
        if (equipment.getId() != 0) {
            equipmentService.updateEquipment(equipment);
        } else {
            equipmentService.saveEquipment(equipment);
        }
        return "redirect:equipment";
    }

    /**
     * 预约设备/根据id,修改预约设备的基本信息
     *
     * @return
     */
    @RequestMapping("/updateEquipment")
    public String updateEquipment(UserEquipment userEquipment, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("systemUser");
        if (userEquipment.getId() != 0) {
            equipmentService.updateEquipmentUser(userEquipment,user);
        } else {
            userEquipment.setUserId(user.getId());
            equipmentService.insertEquipmentUser(userEquipment);
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

    /**
     * 根据用户权限，查询预约设备的基本详情
     *
     * @return
     */
    @RequestMapping("/selectEquipmentUserInfo")
    public String selectEquipmentUserInfo(Model model, UserEquipment userEquipment) {
        List<Map> equipmentList = equipmentService.selectEquipmentUserInfo(userEquipment);
        model.addAttribute("equipmentList", equipmentList);
        return "pages/back/equipment";
    }

    /**
     * 根据id,查询预约设备的基本详情
     *
     * @return
     */
    @RequestMapping("/selectEquipmentUser")
    public String selectEquipmentUser(Model model, UserEquipment userEquipment) {
        UserEquipment equipment = equipmentService.selectEquipmentUser(userEquipment);
        model.addAttribute("equipment", equipment);
        return "pages/back/equipment";
    }

}
