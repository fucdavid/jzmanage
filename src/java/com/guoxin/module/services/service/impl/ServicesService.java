package com.guoxin.module.services.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.services.condition.ServicesCondition;
import com.guoxin.module.services.dao.IServicesDao;
import com.guoxin.module.services.entity.Services;
import com.guoxin.module.services.service.IServicesService;

/**
 * 服务模块 Service层实现类
 * @author cx
 * @createTime 2017-01-12
 */
@Service("servicesService")
public class ServicesService implements IServicesService {
    
    @Resource
    private IServicesDao servicesDao;     //服务模块持久层
    
    /**
     * 得到记录通过主键ID
     * @author cx
     * @param Integer 
     * @createTime 2017-01-12
     * @return 
     */
    public Services getServicesById(Integer id){
        return this.servicesDao.getServicesById(id);
    }
    
    /**
     * 添加服务模块信息
     * @author cx
     * @param services 服务模块实例
     * @createTime 2017-01-12
     * @return 
     */
    public int addServices(Services services) {
        return this.servicesDao.insertServices(services);
    }
    
    /**
     * 根据条件得到所有服务模块的分页列表
     * @author cx
     * @param servicesCondition 查询条件
     * @createTime 2017-01-12
     * @return PageInfo 分页对象
     */
    public PageInfo getServicesPageList(ServicesCondition condition) {
        PageInfo pageInfo = new PageInfo(condition);
        pageInfo.setTotalRows(this.servicesDao.getServicesCount(condition));
        
        if(condition.getPageNum() != null){
            if(pageInfo.getTotalRows() > 0 && condition.getPageNum() > pageInfo.getTotalPages()){
                condition.setPageNum(pageInfo.getTotalPages());
                condition.setLimitOffset();
            }
        }
        
        pageInfo.setItems(this.servicesDao.getServicesPageList(condition));
        return pageInfo;
    }
    
    /**
     * 根据条件得到所有服务模块
     * @author cx
     * @param servicesCondition 查询条件
     * @createTime 2017-01-12
     * @return List 服务模块列表
     */
    public List<Services> getServicesList(ServicesCondition condition) {
        return this.servicesDao.getServicesPageList(condition);
    }
    
    /**
     * 根据条件得到所有服务模块
     * @author cx
     * @param services 服务模块实例
     * @createTime 2017-01-12
     * @return List 服务模块列表
     */
    public List<Services> getServicesList(Services services) {
        return this.servicesDao.getServicesList(services);
    }
    
    /**
     * 根据条件得到所有服务模块数量
     * @author cx
     * @param services 查询条件
     * @createTime 2017-01-12
     * @return Integer 记录数
     */
    public Integer getServicesCount(ServicesCondition condition){
        return this.getServicesCount(condition);
    }
    
    /**
     * 更新服务模块信息
     * @author cx
     * @param services 服务模块实例
     * @createTime 2017-01-12
     * @return 
     */
    public int updateServices(Services services){
        return this.servicesDao.updateServices(services);
    }
    
    /**
     * 删除指定ID的实例
     * @author cx
     * @param id 要删除实例的ID
     * @createTime 2017-01-12
     */
    public int deleteServicesById(Integer id){
        return this.servicesDao.deleteServicesById(id);
    }
    
}
