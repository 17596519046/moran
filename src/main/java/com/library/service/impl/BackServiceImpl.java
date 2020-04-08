package com.library.service.impl;
import com.library.mapper.BackLoginMapper;
import com.library.pojo.User;
import com.library.service.BackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class BackServiceImpl implements BackService {

    @Autowired
    BackLoginMapper backLoginMapper;

    /**
     *
     * @param user 用户名
     * @param request
     * @return
     */
    @Override
    public boolean backLogin(User user, HttpServletRequest request) {
        // 查询数据库获取用户
        User sys = backLoginMapper.selectAccountPassword(user);
        if (sys == null){
            return false;
        }
        request.getSession().setAttribute("systemUser",sys);
        return true;
    }


    /**
     * 添加后台用户信息
     * @param user
     * @return
     */
    @Override
    public boolean saveUser(User user) {
        return backLoginMapper.insertUser(user.setCreateTime(new Date()).setUpdateTime(new Date()));
    }

    /**
     * 修改后台用户信息
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        return backLoginMapper.updateUser(user.setUpdateTime(new Date()));
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<User> selectUserList() {
        return backLoginMapper.selectUserList();
    }

    /***
     * 查询某一用户信息
     * @param userId
     * @return
     */
    @Override
    public User selectUser(Integer userId) {
        return backLoginMapper.selectUser(userId);
    }

    /***
     * 删除用户
     * @param userId
     */
    @Override
    public void deleteUser(Integer userId) {
        backLoginMapper.deleteUser(userId);
    }


}
