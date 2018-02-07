package com.guoxin.module.advice.dao;

import java.util.List;
import com.guoxin.module.advice.condition.AdviceCondition;
import com.guoxin.module.advice.entity.Advice;

/**
 * 用户建议 DAO层接口
 * @author caoxin
 * @createTime 2016-12-17
 */
public interface IAdviceDao {
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param 
     * @createTime 2016-12-17
     * @return Advice
     */
    public Advice getAdviceById(Integer id);
    
    /**
     * 添加用户建议信息
     * @author caoxin
     * @param advice 用户建议实例
     * @createTime 2016-12-17
     * @return 
     */
    public int insertAdvice(Advice advice);
    
    /**
     * 更新用户建议信息
     * @author caoxin
     * @param advice 用户建议实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateAdvice(Advice advice);
    
    /**
     * 根据条件得到所有用户建议的分页列表
     * @author caoxin
     * @param adviceCondition 查询条件
     * @createTime 2016-12-17
     * @return List 用户建议列表
     */
    public List<Advice> getAdvicePageList(AdviceCondition condition);
    
    /**
     * 根据条件得到所有用户建议数量
     * @author caoxin
     * @param advice 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getAdviceCount(AdviceCondition condition);
    
    /**
     * 根据条件得到所有用户建议列表
     * @author caoxin
     * @param advice 查询条件
     * @createTime 2016-12-17
     * @return List 用户建议列表
     */
    public List<Advice> getAdviceList(Advice advice);
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteAdviceById(Integer id);
    
}
