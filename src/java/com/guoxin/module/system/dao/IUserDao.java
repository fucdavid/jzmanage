package com.guoxin.module.system.dao;

import java.util.List;

import com.guoxin.module.system.condition.UserCondition;
import com.guoxin.module.system.entity.Users;

/**
 * 系统用户 DAO层接口
 * @author Rocye
 * @createTime 2013-08-25
 */
public interface IUserDao {
    
    /**
     * 得到记录通过主键ID
     * @author Rocye
     * @param 
     * @createTime 2013-08-25
     * @return User
     */
    public Users getUserById(Integer id);
    
    /**
     * 添加系统用户信息
     * @author Rocye
     * @param user 系统用户实例
     * @createTime 2013-08-25
     * @return 
     */
    public int insertUser(Users user);
    
    /**
     * 更新系统用户信息
     * @author Rocye
     * @param user 系统用户实例
     * @createTime 2013-08-25
     * @return 
     */
    public int updateUser(Users user);
    
    /**
     * 根据条件得到所有系统用户的分页列表
     * @author Rocye
     * @param userCondition 查询条件
     * @createTime 2013-08-25
     * @return List 系统用户列表
     */
    public List<Users> getUserPageList(UserCondition condition);
    
    /**
     * 根据条件得到所有系统用户数量
     * @author Rocye
     * @param user 查询条件
     * @createTime 2013-08-25
     * @return Integer 记录数
     */
    public Integer getUserCount(UserCondition condition);
    
    /**
     * 根据条件得到所有系统用户列表
     * @author Rocye
     * @param user 查询条件
     * @createTime 2013-08-25
     * @return List 系统用户列表
     */
    public List<Users> getUserList(Users user);
    
    /**
     * 删除指定ID的实例
     * @author Rocye
     * @param id 要删除实例的ID
     * @createTime 2013-08-25
     */
    public int deleteUserById(Integer id);
    
}
