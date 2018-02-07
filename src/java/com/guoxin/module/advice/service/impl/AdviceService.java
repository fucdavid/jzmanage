package com.guoxin.module.advice.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.advice.condition.AdviceCondition;
import com.guoxin.module.advice.dao.IAdviceDao;
import com.guoxin.module.advice.entity.Advice;
import com.guoxin.module.advice.service.IAdviceService;

/**
 * 用户建议 Service层实现类
 * @author caoxin
 * @createTime 2016-12-17
 */
@Service("adviceService")
public class AdviceService implements IAdviceService {
    
    @Resource
    private IAdviceDao adviceDao;     //用户建议持久层
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param Integer 
     * @createTime 2016-12-17
     * @return 
     */
    public Advice getAdviceById(Integer id){
        return this.adviceDao.getAdviceById(id);
    }
    
    /**
     * 添加用户建议信息
     * @author caoxin
     * @param advice 用户建议实例
     * @createTime 2016-12-17
     * @return 
     */
    public int addAdvice(Advice advice) {
        return this.adviceDao.insertAdvice(advice);
    }
    
    /**
     * 根据条件得到所有用户建议的分页列表
     * @author caoxin
     * @param adviceCondition 查询条件
     * @createTime 2016-12-17
     * @return PageInfo 分页对象
     */
    public PageInfo getAdvicePageList(AdviceCondition condition) {
        PageInfo pageInfo = new PageInfo(condition);
        pageInfo.setTotalRows(this.adviceDao.getAdviceCount(condition));
        
        if(condition.getPageNum() != null){
            if(pageInfo.getTotalRows() > 0 && condition.getPageNum() > pageInfo.getTotalPages()){
                condition.setPageNum(pageInfo.getTotalPages());
                condition.setLimitOffset();
            }
        }
        
        pageInfo.setItems(this.adviceDao.getAdvicePageList(condition));
        return pageInfo;
    }
    
    /**
     * 根据条件得到所有用户建议
     * @author caoxin
     * @param adviceCondition 查询条件
     * @createTime 2016-12-17
     * @return List 用户建议列表
     */
    public List<Advice> getAdviceList(AdviceCondition condition) {
        return this.adviceDao.getAdvicePageList(condition);
    }
    
    /**
     * 根据条件得到所有用户建议
     * @author caoxin
     * @param advice 用户建议实例
     * @createTime 2016-12-17
     * @return List 用户建议列表
     */
    public List<Advice> getAdviceList(Advice advice) {
        return this.adviceDao.getAdviceList(advice);
    }
    
    /**
     * 根据条件得到所有用户建议数量
     * @author caoxin
     * @param advice 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getAdviceCount(AdviceCondition condition){
        return this.getAdviceCount(condition);
    }
    
    /**
     * 更新用户建议信息
     * @author caoxin
     * @param advice 用户建议实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateAdvice(Advice advice){
        return this.adviceDao.updateAdvice(advice);
    }
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteAdviceById(Integer id){
        return this.adviceDao.deleteAdviceById(id);
    }
    
}
