package com.guoxin.module.system.condition;
import com.guoxin.common.page.BaseCondition;
import com.guoxin.module.system.entity.Users;

/**
 * 用户信息 Condition
 * @author Rocye
 * @createTime 2013-05-22
 */
public class UserCondition extends BaseCondition {
    private Users user;
    
    public UserCondition() {
        this.user = new Users();
    }
    
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
}
