package com.guoxin.module.services.service;

import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.services.condition.ServicesCondition;
import com.guoxin.module.services.entity.Services;

/**
 * 服务模块 Service层接口
 * @author cx
 * @createTime 2017-01-12
 */
public interface IServicesService {
    
    /**
     * 得到记录通过主键ID
     * @author cx
     * @param Integer 
     * @createTime 2017-01-12
     * @return 
     */
    public Services getServicesById(Integer id);
    
    /**
     * 添加服务模块信息
     * @author cx
     * @param services 服务模块实例
     * @createTime 2017-01-12
     * @return 
     */
    public int addServices(Services services);
    
    /**
     * 根据条件得到所有服务模块的分页列表
     * @author cx
     * @param servicesCondition 查询条件
     * @createTime 2017-01-12
     * @return PageInfo 分页对象
     */
    public PageInfo getServicesPageList(ServicesCondition condition);
    
    /**
     * 根据条件得到所有服务模块
     * @author cx
     * @param services 服务模块实例
     * @createTime 2017-01-12
     * @return List 服务模块列表
     */
    public List<Services> getServicesList(Services services);
    
    /**
     * 根据条件得到所有服务模块
     * @author cx
     * @param servicesCondition 查询条件
     * @createTime 2017-01-12
     * @return List 服务模块列表
     */
    public List<Services> getServicesList(ServicesCondition condition);
    
    /**
     * 根据条件得到所有服务模块数量
     * @author cx
     * @param services 查询条件
     * @createTime 2017-01-12
     * @return Integer 记录数
     */
    public Integer getServicesCount(ServicesCondition condition);
    
    /**
     * 删除指定ID的实例
     * @author cx
     * @param id 要删除实例的ID
     * @createTime 2017-01-12
     */
    public int deleteServicesById(Integer id);
    
    /**
     * 更新服务模块信息
     * @author cx
     * @param services 服务模块实例
     * @createTime 2017-01-12
     * @return 
     */
    public int updateServices(Services services);
    
}
