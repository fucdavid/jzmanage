package com.guoxin.common.tag;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import com.guoxin.common.base.Constants;

/**
 * JSTL版本自定义权限标签
 * 
 * @author Rocye
 * @createTime 2015-07-21
 */
public class PermissionTag extends BodyTagSupport {

    private static final long serialVersionUID = -5092755176881300079L;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int doStartTag() throws JspException {
        
        HttpSession session = (HttpSession) this.pageContext.getSession();
        Object roleObj = session.getAttribute(Constants.ROLES_KEY);
        String roleIds = (roleObj ==null ? "" : roleObj.toString());
        //是否有此菜单权限
        roleIds = "," + roleIds + ",";
        if(roleIds.indexOf("," + this.token + ",") == -1){
            return SKIP_BODY;
        }else{
            return EVAL_BODY_INCLUDE;
        }
    }
}
