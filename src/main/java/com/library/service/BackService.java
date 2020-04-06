package com.library.service;

import com.library.pojo.User;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BackService {
    /**
     * 后台登录接口
     * @param user 用户名
     * @return
     */
    boolean backLogin(User user, HttpServletRequest request);

    /**
     * 添加后台用户信息
     * @param user
     * @return
     */
    boolean saveUser(User user);
    /**
     * 修改后台用户信息
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectUserList();

    /**
     * 查询用户信息，根据id
     * @return
     */
    User selectUser(Integer userId);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);
}
