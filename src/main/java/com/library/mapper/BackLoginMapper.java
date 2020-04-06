package com.library.mapper;
import com.library.pojo.User;
import java.util.List;

public interface BackLoginMapper {
    /**
     * 登录
     * @param user
     * @return
     */
    User selectAccountPassword(User user);

    /**
     * 添加后台用户信息
     * @param user
     * @return
     */
    boolean insertUser(User user);

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
     * 查询用户信息,根据id
     * @return
     */
    User selectUser(Integer id);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);
}
