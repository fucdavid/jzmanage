package com.guoxin.module.clientInfo.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.clientInfo.condition.ClientInfoCondition;
import com.guoxin.module.clientInfo.dao.IClientInfoDao;
import com.guoxin.module.clientInfo.entity.ClientInfo;
import com.guoxin.module.clientInfo.service.IClientInfoService;

/**
 * 客户信息 Service层实现类
 * @author caoxin
 * @createTime 2016-12-17
 */
@Service("clientInfoService")
public class ClientInfoService implements IClientInfoService {
    
    @Resource
    private IClientInfoDao clientInfoDao;     //客户信息持久层
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param Integer 
     * @createTime 2016-12-17
     * @return 
     */
    public ClientInfo getClientInfoById(Integer id){
        return this.clientInfoDao.getClientInfoById(id);
    }
    
    /**
     * 添加客户信息信息
     * @author caoxin
     * @param clientInfo 客户信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int addClientInfo(ClientInfo clientInfo) {
        return this.clientInfoDao.insertClientInfo(clientInfo);
    }
    
    /**
     * 根据条件得到所有客户信息的分页列表
     * @author caoxin
     * @param clientInfoCondition 查询条件
     * @createTime 2016-12-17
     * @return PageInfo 分页对象
     */
    public PageInfo getClientInfoPageList(ClientInfoCondition condition) {
        PageInfo pageInfo = new PageInfo(condition);
        pageInfo.setTotalRows(this.clientInfoDao.getClientInfoCount(condition));
        
        if(condition.getPageNum() != null){
            if(pageInfo.getTotalRows() > 0 && condition.getPageNum() > pageInfo.getTotalPages()){
                condition.setPageNum(pageInfo.getTotalPages());
                condition.setLimitOffset();
            }
        }
        
        pageInfo.setItems(this.clientInfoDao.getClientInfoPageList(condition));
        return pageInfo;
    }
    
    /**
     * 根据条件得到所有客户信息
     * @author caoxin
     * @param clientInfoCondition 查询条件
     * @createTime 2016-12-17
     * @return List 客户信息列表
     */
    public List<ClientInfo> getClientInfoList(ClientInfoCondition condition) {
        return this.clientInfoDao.getClientInfoPageList(condition);
    }
    
    /**
     * 根据条件得到所有客户信息
     * @author caoxin
     * @param clientInfo 客户信息实例
     * @createTime 2016-12-17
     * @return List 客户信息列表
     */
    public List<ClientInfo> getClientInfoList(ClientInfo clientInfo) {
        return this.clientInfoDao.getClientInfoList(clientInfo);
    }
    
    /**
     * 根据条件得到所有客户信息数量
     * @author caoxin
     * @param clientInfo 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getClientInfoCount(ClientInfoCondition condition){
        return this.getClientInfoCount(condition);
    }
    
    /**
     * 更新客户信息信息
     * @author caoxin
     * @param clientInfo 客户信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateClientInfo(ClientInfo clientInfo){
        return this.clientInfoDao.updateClientInfo(clientInfo);
    }
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteClientInfoById(Integer id){
        return this.clientInfoDao.deleteClientInfoById(id);
    }
    
}
