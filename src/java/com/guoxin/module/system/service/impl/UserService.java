package com.guoxin.module.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.guoxin.common.page.PageInfo;
import com.guoxin.common.util.MD5;
import com.guoxin.common.util.Utilities;
import com.guoxin.module.system.condition.UserCondition;
import com.guoxin.module.system.dao.IUserDao;
import com.guoxin.module.system.entity.Users;
import com.guoxin.module.system.service.IUserService;

/**
 * 用户信息 Service层实现类
 * @author Rocye
 * @createTime 2013-05-22
 */
@Service("userService")
public class UserService implements IUserService {
    
    @Resource
    private IUserDao userDao;
    
    
    /**
     * 用户登录系统
     * @author Rocye
     * @createTime 2015-10-13
     * @param user 用户
     * @return
     */
    public Map<String, Object> loginSystemByUser(Users user) {
        Map<String, Object> resultMap = new HashMap<String, Object>(0);
        
        Users dbUser = new Users();
        dbUser.setDeleteFlag(false);
        dbUser.setLoginName(user.getLoginName());
        List<Users> userList = this.userDao.getUserList(dbUser);
        
        if(userList.size() == 0){
            resultMap.put("msgid", 0);
            resultMap.put("msg", "登录名不存在!");
        }else{
            dbUser = userList.get(0);
//            String upValue = MD5.encode(Utilities.encryptPassword(user.getLoginName().trim(), user.getPassword()));
//            String lowerValue = MD5.encode(Utilities.encryptPassword(user.getLoginName().trim(), user.getPassword()));
            
            if (dbUser.getPassword().equals(user.getPassword().trim())) {
                resultMap.put("msgid", 1);
                resultMap.put("user", dbUser);
            }else{
                resultMap.put("msgid", 0);
                resultMap.put("msg", "登录名或密码有误!");
            }
        }
        return resultMap;
    }
    
    /**
     * 得到记录通过主键ID
     * @author Rocye
     * @param Integer 
     * @createTime 2013-05-22
     * @return 
     */
    public Users getUserById(Integer id){
        return this.userDao.getUserById(id);
    }
    
    /**
     * 添加系统用户信息
     * @author Rocye
     * @param user 系统用户实例
     * @createTime 2013-08-25
     * @return 
     */
    public int insertUser(Users user){
        return this.userDao.insertUser(user);
    }
    
    /**
     * 根据条件得到所有用户信息的分页列表
     * @author Rocye
     * @param userCondition 查询条件
     * @createTime 2013-05-22
     * @return PageInfo 分页对象
     */
    public PageInfo getUserPageList(UserCondition condition) {
        PageInfo pageInfo = new PageInfo(condition);
        pageInfo.setTotalRows(this.userDao.getUserCount(condition));
        
        if(condition.getPageNum() != null){
            if(pageInfo.getTotalRows() > 0 && condition.getPageNum() > pageInfo.getTotalPages()){
                condition.setPageNum(pageInfo.getTotalPages());
                condition.setLimitOffset();
            }
        }
        
        pageInfo.setItems(this.userDao.getUserPageList(condition));
        return pageInfo;
    }
    
    /**
     * 根据条件得到所有用户信息
     * @author Rocye
     * @param user 用户信息实例
     * @createTime 2013-05-22
     * @return List 用户信息列表
     */
    public List<Users> getUserList(Users user) {
        return this.userDao.getUserList(user);
    }
    
    /**
     * 更新用户信息信息
     * @author Rocye
     * @param user 用户信息实例
     * @createTime 2013-05-22
     * @return 
     */
    public int updateUser(Users user){
        return this.userDao.updateUser(user);
    }
    
    /**
     * 删除指定ID的实例
     * @author Rocye
     * @param id 要删除实例的ID
     * @createTime 2013-05-22
     */
    public int deleteUserById(Integer id){
        return this.userDao.deleteUserById(id);
    }
    
}
