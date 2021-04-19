package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatsysdao.UserDao;
import com.bankapi.bankapi.model.dormatsys.User;
import com.bankapi.bankapi.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.sevice.iml
 * @program: bankapi
 * @className: UserServiceIml
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-17  21:02
 * @description: UserService 实现类
 **/
@Service
public class UserServiceIml implements UserService {

    @Autowired
    UserDao userDao;

    /**
     * @param user 需要保存的数据
     * @return 保存数据的条数
     */
    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    /**
     * 根据id删除用户数据
     * @param id 用户id
     * @return
     */
    @Override
    public int removeUserById(Long id) {
        return userDao.removeUserById(id);
    }

    /**
     * 用户数据更新
     * @param user 更新的数据
     * @return
     */
    @Override
    public int UpdateUserById(User user) {
        return userDao.UpdateUserById(user);
    }

    /**
     *根据id查找用户
     * @param id 用户id
     * @return
     */
    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    /**
     * 获取所用的用户数据
     * @return 用户数据
     */
    @Override
    public List<User> findAllUsers() {
        return userDao.findUsers();
    }

    /**
     * 分页查询用户数据
     * @param start 开始index
     * @param end 结束index
     * @return
     */
    @Override
    public List<User> page(int start, int end) {
        return userDao.page(start,end);
    }
}
