package com.bankapi.bankapi.dao.dormatsysdao;

import com.bankapi.bankapi.model.dormatsys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.dao
 * @program: bankapi
 * @className: Userdao
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-13  22:27
 * @description: 用户数据持久化
 **/
@Mapper
public interface UserDao {

    /**
     * 保存用户
     * @param user 需要保存的数据
     * @return 返回保存的数量
     */
    public int saveUser(User user);

    /**
     * 根据id删除用户
     * @param id 用户id
     * @return 返回查询到的结果
     */
    public int removeUserById(@Param("id") Long id);


    /**
     * 更新用户数据
     * @param user
     * @return 返回修改的数量
     */
    public int UpdateUserById(@Param("user")User user);

    /**
     * 根据id查找用户
     * @param id 用户id
     * @return   返回查询到的结果
     */
    public User findUserById(@Param("id") Long id);

    /**
     * 根据用户名查找用户信息
     * @param username 用户名
     * @return 返回用户信息
     */
    public User findUserByUsername(@Param("username") String username);

    /**
     * 查询所有用户数据
     * @return 返回查询到的结果 list
     */
    public List<User> findUsers();

    /**
     * 分页查询
     * @param start 开始index
     * @param end 结束index
     * @return 返回list
     */
    public List<User> page(@Param("start") int start, @Param("end") int end);

}
