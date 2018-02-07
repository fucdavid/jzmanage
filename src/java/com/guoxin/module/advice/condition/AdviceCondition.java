package com.guoxin.module.advice.condition;
import com.guoxin.common.page.BaseCondition;
import com.guoxin.module.advice.entity.Advice;

/**
 * 用户建议 Condition
 * @author caoxin
 * @createTime 2016-12-17
 */
public class AdviceCondition extends BaseCondition {
    private Advice advice;
    
    public AdviceCondition() {
        this.advice = new Advice();
    }
    
    public AdviceCondition(Advice advice) {
        this.advice = advice;
    }
    
    public Advice getAdvice() {
        return advice;
    }
    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
