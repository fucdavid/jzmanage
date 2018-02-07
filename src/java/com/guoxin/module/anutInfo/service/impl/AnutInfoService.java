package com.guoxin.module.anutInfo.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.anutInfo.condition.AnutInfoCondition;
import com.guoxin.module.anutInfo.dao.IAnutInfoDao;
import com.guoxin.module.anutInfo.entity.AnutInfo;
import com.guoxin.module.anutInfo.service.IAnutInfoService;

/**
 * 阿姨信息 Service层实现类
 * @author caoxin
 * @createTime 2016-12-17
 */
@Service("anutInfoService")
public class AnutInfoService implements IAnutInfoService {
    
    @Resource
    private IAnutInfoDao anutInfoDao;     //阿姨信息持久层
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param Integer 
     * @createTime 2016-12-17
     * @return 
     */
    public AnutInfo getAnutInfoById(Integer id){
        return this.anutInfoDao.getAnutInfoById(id);
    }
    
    /**
     * 添加阿姨信息信息
     * @author caoxin
     * @param anutInfo 阿姨信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int addAnutInfo(AnutInfo anutInfo) {
        return this.anutInfoDao.insertAnutInfo(anutInfo);
    }
    
    /**
     * 根据条件得到所有阿姨信息的分页列表
     * @author caoxin
     * @param anutInfoCondition 查询条件
     * @createTime 2016-12-17
     * @return PageInfo 分页对象
     */
    public PageInfo getAnutInfoPageList(AnutInfoCondition condition) {
        PageInfo pageInfo = new PageInfo(condition);
        pageInfo.setTotalRows(this.anutInfoDao.getAnutInfoCount(condition));
        
        if(condition.getPageNum() != null){
            if(pageInfo.getTotalRows() > 0 && condition.getPageNum() > pageInfo.getTotalPages()){
                condition.setPageNum(pageInfo.getTotalPages());
                condition.setLimitOffset();
            }
        }
        
        pageInfo.setItems(this.anutInfoDao.getAnutInfoPageList(condition));
        return pageInfo;
    }
    
    /**
     * 根据条件得到所有阿姨信息
     * @author caoxin
     * @param anutInfoCondition 查询条件
     * @createTime 2016-12-17
     * @return List 阿姨信息列表
     */
    public List<AnutInfo> getAnutInfoList(AnutInfoCondition condition) {
        return this.anutInfoDao.getAnutInfoPageList(condition);
    }
    
    /**
     * 根据条件得到所有阿姨信息
     * @author caoxin
     * @param anutInfo 阿姨信息实例
     * @createTime 2016-12-17
     * @return List 阿姨信息列表
     */
    public List<AnutInfo> getAnutInfoList(AnutInfo anutInfo) {
        return this.anutInfoDao.getAnutInfoList(anutInfo);
    }
    
    /**
     * 根据条件得到所有阿姨信息数量
     * @author caoxin
     * @param anutInfo 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getAnutInfoCount(AnutInfoCondition condition){
        return this.getAnutInfoCount(condition);
    }
    
    /**
     * 更新阿姨信息信息
     * @author caoxin
     * @param anutInfo 阿姨信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateAnutInfo(AnutInfo anutInfo){
        return this.anutInfoDao.updateAnutInfo(anutInfo);
    }
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteAnutInfoById(Integer id){
        return this.anutInfoDao.deleteAnutInfoById(id);
    }
    
}
