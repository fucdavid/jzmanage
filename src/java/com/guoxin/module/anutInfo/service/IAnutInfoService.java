package com.guoxin.module.anutInfo.service;

import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.anutInfo.condition.AnutInfoCondition;
import com.guoxin.module.anutInfo.entity.AnutInfo;

/**
 * 阿姨信息 Service层接口
 * @author caoxin
 * @createTime 2016-12-17
 */
public interface IAnutInfoService {
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param Integer 
     * @createTime 2016-12-17
     * @return 
     */
    public AnutInfo getAnutInfoById(Integer id);
    
    /**
     * 添加阿姨信息信息
     * @author caoxin
     * @param anutInfo 阿姨信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int addAnutInfo(AnutInfo anutInfo);
    
    /**
     * 根据条件得到所有阿姨信息的分页列表
     * @author caoxin
     * @param anutInfoCondition 查询条件
     * @createTime 2016-12-17
     * @return PageInfo 分页对象
     */
    public PageInfo getAnutInfoPageList(AnutInfoCondition condition);
    
    /**
     * 根据条件得到所有阿姨信息
     * @author caoxin
     * @param anutInfo 阿姨信息实例
     * @createTime 2016-12-17
     * @return List 阿姨信息列表
     */
    public List<AnutInfo> getAnutInfoList(AnutInfo anutInfo);
    
    /**
     * 根据条件得到所有阿姨信息
     * @author caoxin
     * @param anutInfoCondition 查询条件
     * @createTime 2016-12-17
     * @return List 阿姨信息列表
     */
    public List<AnutInfo> getAnutInfoList(AnutInfoCondition condition);
    
    /**
     * 根据条件得到所有阿姨信息数量
     * @author caoxin
     * @param anutInfo 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getAnutInfoCount(AnutInfoCondition condition);
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteAnutInfoById(Integer id);
    
    /**
     * 更新阿姨信息信息
     * @author caoxin
     * @param anutInfo 阿姨信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateAnutInfo(AnutInfo anutInfo);
    
}
