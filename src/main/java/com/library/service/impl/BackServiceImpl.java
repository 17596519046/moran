package com.library.service.impl;
import com.library.mapper.BackLoginMapper;
import com.library.pojo.User;
import com.library.service.BackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
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
        request.getSession().setAttribute("User",sys);
        return true;
    }


    /**
     * 添加后台用户信息
     * @param user
     * @return
     */
    @Override
    public boolean saveUser(User user, HttpServletRequest request) {
        boolean b = backLoginMapper.insertUser(user.setCreateTime(new Date()).setUpdateTime(new Date()));
        User sys = backLoginMapper.selectAccountPassword(user);
        request.getSession().setAttribute("User",sys);
        return b;
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
        List<User> users = backLoginMapper.selectUserList();
        for (User user : users) {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
            user.setCreateTime1(sdf.format(user.getCreateTime()));
            // 如果入学时间不为空，转换时间格式
            if (user.getGraduateTime() != null) {
                user.setGraduateTime1(sdf.format(user.getGraduateTime()));
            }
            // 如果毕业时间不为空，转换时间格式
            if (user.getEntranceTime() != null) {
                user.setEntranceTime1(sdf.format(user.getEntranceTime()));
            }
        }
        return users;
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
