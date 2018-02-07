package com.guoxin.module.services.dao;

import java.util.List;
import com.guoxin.module.services.condition.ServicesCondition;
import com.guoxin.module.services.entity.Services;

/**
 * 服务模块 DAO层接口
 * @author cx
 * @createTime 2017-01-12
 */
public interface IServicesDao {
    
    /**
     * 得到记录通过主键ID
     * @author cx
     * @param 
     * @createTime 2017-01-12
     * @return Services
     */
    public Services getServicesById(Integer id);
    
    /**
     * 添加服务模块信息
     * @author cx
     * @param services 服务模块实例
     * @createTime 2017-01-12
     * @return 
     */
    public int insertServices(Services services);
    
    /**
     * 更新服务模块信息
     * @author cx
     * @param services 服务模块实例
     * @createTime 2017-01-12
     * @return 
     */
    public int updateServices(Services services);
    
    /**
     * 根据条件得到所有服务模块的分页列表
     * @author cx
     * @param servicesCondition 查询条件
     * @createTime 2017-01-12
     * @return List 服务模块列表
     */
    public List<Services> getServicesPageList(ServicesCondition condition);
    
    /**
     * 根据条件得到所有服务模块数量
     * @author cx
     * @param services 查询条件
     * @createTime 2017-01-12
     * @return Integer 记录数
     */
    public Integer getServicesCount(ServicesCondition condition);
    
    /**
     * 根据条件得到所有服务模块列表
     * @author cx
     * @param services 查询条件
     * @createTime 2017-01-12
     * @return List 服务模块列表
     */
    public List<Services> getServicesList(Services services);
    
    /**
     * 删除指定ID的实例
     * @author cx
     * @param id 要删除实例的ID
     * @createTime 2017-01-12
     */
    public int deleteServicesById(Integer id);
    
}
