package com.library.controller;
import com.library.pojo.User;
import com.library.service.BackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/back")
@Controller
public class BackController {

    @Autowired
    BackService backService;

    /***
     * 跳转到后台主页
     * @return
     */
    @RequestMapping("/index")
    public String backIndex() {
        // 跳到后台主页
        return "static/pages/back/index";
    }

    /***
     * 跳到登陆页面
     * @return
     */
    @RequestMapping("/login")
    public String backLogin() {
        // 跳到登陆页面
        return "static/pages/back/login";
    }

    /***
     * 注销
     * @param request
     * @return
     */
    @RequestMapping("loginOut")
    public String loginOut(HttpServletRequest request) {
        request.getSession().removeAttribute("User");
        return "static/pages/back/login";
    }

    /**
     * 后台登录接口
     *
     * @return
     */
    @RequestMapping("/toLogin")
    @ResponseBody
    public Map selectAll(User user, HttpServletRequest request) {
        // service层调用后台登陆接口
        boolean b = backService.backLogin(user, request);
        HashMap map = new HashMap();
        map.put("success", b);
        return map;
    }

    /**
     * 修改后台用户信息
     *
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user, HttpServletRequest request) {
        // 如果用户id不为0 说明是修改 为0 或者为 null 是新增
        if (user.getId() != null && user.getId() != 0) {
            backService.updateUser(user);
        } else {
            backService.saveUser(user, request);
        }
        return "redirect:user";
    }

    /**
     * 删除用户
     *
     * @return
     */
    @RequestMapping("/removeUser")
    public String removeUser(Integer userId) {
        backService.deleteUser(userId);
        return "redirect:user";
    }

    /**
     * 通过id获取一个用户
     *
     * @return
     */
    @RequestMapping("/getUserId")
    public String getUserId(Model model, Integer userId) {
        User user = backService.selectUser(userId);
        model.addAttribute("user", user);
        return "static/pages/back/userinsert";
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping("/user")
    public String selectSystemUserList(Model model) {
        List<User> userList = backService.selectUserList();
        model.addAttribute("all", userList);
        return "static/pages/back/user";
    }

}
