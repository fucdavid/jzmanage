package com.guoxin.module.anutInfo.condition;
import com.guoxin.common.page.BaseCondition;
import com.guoxin.module.anutInfo.entity.AnutInfo;

/**
 * 阿姨信息 Condition
 * @author caoxin
 * @createTime 2016-12-17
 */
public class AnutInfoCondition extends BaseCondition {
    private AnutInfo anutInfo;
    
    public AnutInfoCondition() {
        this.anutInfo = new AnutInfo();
    }
    
    public AnutInfoCondition(AnutInfo anutInfo) {
        this.anutInfo = anutInfo;
    }
    
    public AnutInfo getAnutInfo() {
        return anutInfo;
    }
    public void setAnutInfo(AnutInfo anutInfo) {
        this.anutInfo = anutInfo;
    }
}
