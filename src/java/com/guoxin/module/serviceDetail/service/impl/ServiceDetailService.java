package com.guoxin.module.serviceDetail.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.serviceDetail.condition.ServiceDetailCondition;
import com.guoxin.module.serviceDetail.dao.IServiceDetailDao;
import com.guoxin.module.serviceDetail.entity.ServiceDetail;
import com.guoxin.module.serviceDetail.service.IServiceDetailService;

/**
 * 服务详细信息 Service层实现类
 * @author cx
 * @createTime 2017-01-12
 */
@Service("serviceDetailService")
public class ServiceDetailService implements IServiceDetailService {
    
    @Resource
    private IServiceDetailDao serviceDetailDao;     //服务详细信息持久层
    
    /**
     * 得到记录通过主键ID
     * @author cx
     * @param Integer 
     * @createTime 2017-01-12
     * @return 
     */
    public ServiceDetail getServiceDetailById(Integer id){
        return this.serviceDetailDao.getServiceDetailById(id);
    }
    
    /**
     * 添加服务详细信息信息
     * @author cx
     * @param serviceDetail 服务详细信息实例
     * @createTime 2017-01-12
     * @return 
     */
    public int addServiceDetail(ServiceDetail serviceDetail) {
        return this.serviceDetailDao.insertServiceDetail(serviceDetail);
    }
    
    /**
     * 根据条件得到所有服务详细信息的分页列表
     * @author cx
     * @param serviceDetailCondition 查询条件
     * @createTime 2017-01-12
     * @return PageInfo 分页对象
     */
    public PageInfo getServiceDetailPageList(ServiceDetailCondition condition) {
        PageInfo pageInfo = new PageInfo(condition);
        pageInfo.setTotalRows(this.serviceDetailDao.getServiceDetailCount(condition));
        
        if(condition.getPageNum() != null){
            if(pageInfo.getTotalRows() > 0 && condition.getPageNum() > pageInfo.getTotalPages()){
                condition.setPageNum(pageInfo.getTotalPages());
                condition.setLimitOffset();
            }
        }
        
        pageInfo.setItems(this.serviceDetailDao.getServiceDetailPageList(condition));
        return pageInfo;
    }
    
    /**
     * 根据条件得到所有服务详细信息
     * @author cx
     * @param serviceDetailCondition 查询条件
     * @createTime 2017-01-12
     * @return List 服务详细信息列表
     */
    public List<ServiceDetail> getServiceDetailList(ServiceDetailCondition condition) {
        return this.serviceDetailDao.getServiceDetailPageList(condition);
    }
    
    /**
     * 根据条件得到所有服务详细信息
     * @author cx
     * @param serviceDetail 服务详细信息实例
     * @createTime 2017-01-12
     * @return List 服务详细信息列表
     */
    public List<ServiceDetail> getServiceDetailList(ServiceDetail serviceDetail) {
        return this.serviceDetailDao.getServiceDetailList(serviceDetail);
    }
    
    /**
     * 根据条件得到所有服务详细信息数量
     * @author cx
     * @param serviceDetail 查询条件
     * @createTime 2017-01-12
     * @return Integer 记录数
     */
    public Integer getServiceDetailCount(ServiceDetailCondition condition){
        return this.getServiceDetailCount(condition);
    }
    
    /**
     * 更新服务详细信息信息
     * @author cx
     * @param serviceDetail 服务详细信息实例
     * @createTime 2017-01-12
     * @return 
     */
    public int updateServiceDetail(ServiceDetail serviceDetail){
        return this.serviceDetailDao.updateServiceDetail(serviceDetail);
    }
    
    /**
     * 删除指定ID的实例
     * @author cx
     * @param id 要删除实例的ID
     * @createTime 2017-01-12
     */
    public int deleteServiceDetailById(Integer id){
        return this.serviceDetailDao.deleteServiceDetailById(id);
    }
    
}
