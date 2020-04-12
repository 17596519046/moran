package com.library.controller;
import com.library.pojo.Equipment;
import com.library.pojo.Laboratory;
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
        if (equipment.getId() != null && equipment.getId() != 0) {
            equipmentService.updateEquipment(equipment);
        } else {
            equipmentService.saveEquipment(equipment);
        }
        return "redirect:equipment";
    }

    /**
     * 查询所有设备
     *
     * @return
     */
    @RequestMapping("/equipment")
    public String selectEquipmentList(Model model) {
        List<Equipment> equipmentList = equipmentService.selectEquipmentList();
        model.addAttribute("all", equipmentList);
        return "static/pages/back/equipment";
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
        return "static/pages/back/equipmentinsert";
    }

    /**
     * 查询预约实验室的信息
     */
    @RequestMapping("/selectEquipmentUserInfo")
    public String selectEquipmentUserInfo(Model model) {
        List<Equipment> EquipmentList = equipmentService.selectEquipmentUserInfo();
        model.addAttribute("EquipmentList", EquipmentList);
        return "static/pages/back/equipmentexamine";
    }

    /**
     * 通过或者拒绝设备
     */
    @RequestMapping("/appointmentEquipment")
    public String appointmentEquipment(int state, Integer id, HttpServletRequest request) {
        equipmentService.appointmentEquipment(state, id, request);
        return "redirect: selectEquipmentUserInfo";
    }

    /**
     * 预约详情
     *
     * @return
     */
    @RequestMapping("/getEquipmentappiont")
    public String getEquipmentappiont(Model model, Integer state) {
        List<Equipment> EquipmentList = equipmentService.getEquipmentappiont(state);
        model.addAttribute("all", EquipmentList);
        return "static/pages/back/equipmentappiont";
    }
    /**
     * 我预约的设备
     *
     * @return
     */
    @RequestMapping("/getMyEquipment")
    public String getMyEquipment(Model model, HttpServletRequest request) {
        List<Equipment> EquipmentList = equipmentService.getMyEquipment(request);
        model.addAttribute("all", EquipmentList);
        return "static/pages/back/equipmentappiont";
    }


    /**
     * 预约按钮
     *
     * @return
     */
    @RequestMapping("/insertUserEquipment")
    public String insertUserEquipment(Model model, HttpServletRequest request, int id, String retrurnTime) {
        equipmentService.insertUserEquipment(request, id,retrurnTime);
        return "redirect: equipment";
    }

    /**
     * 归还按钮
     *
     * @return
     */
    @RequestMapping("/returnEquipment")
    public String returnEquipment(Model model, HttpServletRequest request, int id) {
        equipmentService.returnEquipment(request, id);
        return "redirect: getMyEquipment";
    }

}
