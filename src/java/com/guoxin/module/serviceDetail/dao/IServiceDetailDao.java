package com.guoxin.module.serviceDetail.dao;

import java.util.List;
import com.guoxin.module.serviceDetail.condition.ServiceDetailCondition;
import com.guoxin.module.serviceDetail.entity.ServiceDetail;

/**
 * 服务详细信息 DAO层接口
 * @author cx
 * @createTime 2017-01-12
 */
public interface IServiceDetailDao {
    
    /**
     * 得到记录通过主键ID
     * @author cx
     * @param 
     * @createTime 2017-01-12
     * @return ServiceDetail
     */
    public ServiceDetail getServiceDetailById(Integer id);
    
    /**
     * 添加服务详细信息信息
     * @author cx
     * @param serviceDetail 服务详细信息实例
     * @createTime 2017-01-12
     * @return 
     */
    public int insertServiceDetail(ServiceDetail serviceDetail);
    
    /**
     * 更新服务详细信息信息
     * @author cx
     * @param serviceDetail 服务详细信息实例
     * @createTime 2017-01-12
     * @return 
     */
    public int updateServiceDetail(ServiceDetail serviceDetail);
    
    /**
     * 根据条件得到所有服务详细信息的分页列表
     * @author cx
     * @param serviceDetailCondition 查询条件
     * @createTime 2017-01-12
     * @return List 服务详细信息列表
     */
    public List<ServiceDetail> getServiceDetailPageList(ServiceDetailCondition condition);
    
    /**
     * 根据条件得到所有服务详细信息数量
     * @author cx
     * @param serviceDetail 查询条件
     * @createTime 2017-01-12
     * @return Integer 记录数
     */
    public Integer getServiceDetailCount(ServiceDetailCondition condition);
    
    /**
     * 根据条件得到所有服务详细信息列表
     * @author cx
     * @param serviceDetail 查询条件
     * @createTime 2017-01-12
     * @return List 服务详细信息列表
     */
    public List<ServiceDetail> getServiceDetailList(ServiceDetail serviceDetail);
    
    /**
     * 删除指定ID的实例
     * @author cx
     * @param id 要删除实例的ID
     * @createTime 2017-01-12
     */
    public int deleteServiceDetailById(Integer id);
    
}
