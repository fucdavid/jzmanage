package com.guoxin.module.system.service;

import java.util.List;
import java.util.Map;

import com.guoxin.common.page.PageInfo;
import com.guoxin.module.system.condition.UserCondition;
import com.guoxin.module.system.entity.Users;

/**
 * 用户信息 Service层接口
 * @author Rocye
 * @createTime 2013-05-22
 */
public interface IUserService {
    
    /**
     * 用户登录系统
     * @author Rocye
     * @createTime 2015-10-13
     * @param user 用户
     * @return
     */
    public Map<String, Object> loginSystemByUser(Users user);
    
    /**
     * 得到记录通过主键ID
     * @author Rocye
     * @param Integer 
     * @createTime 2013-05-22
     * @return 
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
     * 根据条件得到所有用户信息的分页列表
     * @author Rocye
     * @param userCondition 查询条件
     * @createTime 2013-05-22
     * @return PageInfo 分页对象
     */
    public PageInfo getUserPageList(UserCondition condition);
    
    /**
     * 根据条件得到所有用户信息
     * @author Rocye
     * @param user 用户信息实例
     * @createTime 2013-05-22
     * @return List 用户信息列表
     */
    public List<Users> getUserList(Users user);
    
    /**
     * 删除指定ID的实例
     * @author Rocye
     * @param id 要删除实例的ID
     * @createTime 2013-05-22
     */
    public int deleteUserById(Integer id);
    
    /**
     * 更新用户信息信息
     * @author Rocye
     * @param user 用户信息实例
     * @createTime 2013-05-22
     * @return 
     */
    public int updateUser(Users user);
    
}
