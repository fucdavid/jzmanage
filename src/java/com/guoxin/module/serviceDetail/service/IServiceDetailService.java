package com.guoxin.module.serviceDetail.service;

import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.serviceDetail.condition.ServiceDetailCondition;
import com.guoxin.module.serviceDetail.entity.ServiceDetail;

/**
 * 服务详细信息 Service层接口
 * @author cx
 * @createTime 2017-01-12
 */
public interface IServiceDetailService {
    
    /**
     * 得到记录通过主键ID
     * @author cx
     * @param Integer 
     * @createTime 2017-01-12
     * @return 
     */
    public ServiceDetail getServiceDetailById(Integer id);
    
    /**
     * 添加服务详细信息信息
     * @author cx
     * @param serviceDetail 服务详细信息实例
     * @createTime 2017-01-12
     * @return 
     */
    public int addServiceDetail(ServiceDetail serviceDetail);
    
    /**
     * 根据条件得到所有服务详细信息的分页列表
     * @author cx
     * @param serviceDetailCondition 查询条件
     * @createTime 2017-01-12
     * @return PageInfo 分页对象
     */
    public PageInfo getServiceDetailPageList(ServiceDetailCondition condition);
    
    /**
     * 根据条件得到所有服务详细信息
     * @author cx
     * @param serviceDetail 服务详细信息实例
     * @createTime 2017-01-12
     * @return List 服务详细信息列表
     */
    public List<ServiceDetail> getServiceDetailList(ServiceDetail serviceDetail);
    
    /**
     * 根据条件得到所有服务详细信息
     * @author cx
     * @param serviceDetailCondition 查询条件
     * @createTime 2017-01-12
     * @return List 服务详细信息列表
     */
    public List<ServiceDetail> getServiceDetailList(ServiceDetailCondition condition);
    
    /**
     * 根据条件得到所有服务详细信息数量
     * @author cx
     * @param serviceDetail 查询条件
     * @createTime 2017-01-12
     * @return Integer 记录数
     */
    public Integer getServiceDetailCount(ServiceDetailCondition condition);
    
    /**
     * 删除指定ID的实例
     * @author cx
     * @param id 要删除实例的ID
     * @createTime 2017-01-12
     */
    public int deleteServiceDetailById(Integer id);
    
    /**
     * 更新服务详细信息信息
     * @author cx
     * @param serviceDetail 服务详细信息实例
     * @createTime 2017-01-12
     * @return 
     */
    public int updateServiceDetail(ServiceDetail serviceDetail);
    
}
