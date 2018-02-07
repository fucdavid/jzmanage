package com.guoxin.module.clientInfo.service;

import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.clientInfo.condition.ClientInfoCondition;
import com.guoxin.module.clientInfo.entity.ClientInfo;

/**
 * 客户信息 Service层接口
 * @author caoxin
 * @createTime 2016-12-17
 */
public interface IClientInfoService {
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param Integer 
     * @createTime 2016-12-17
     * @return 
     */
    public ClientInfo getClientInfoById(Integer id);
    
    /**
     * 添加客户信息信息
     * @author caoxin
     * @param clientInfo 客户信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int addClientInfo(ClientInfo clientInfo);
    
    /**
     * 根据条件得到所有客户信息的分页列表
     * @author caoxin
     * @param clientInfoCondition 查询条件
     * @createTime 2016-12-17
     * @return PageInfo 分页对象
     */
    public PageInfo getClientInfoPageList(ClientInfoCondition condition);
    
    /**
     * 根据条件得到所有客户信息
     * @author caoxin
     * @param clientInfo 客户信息实例
     * @createTime 2016-12-17
     * @return List 客户信息列表
     */
    public List<ClientInfo> getClientInfoList(ClientInfo clientInfo);
    
    /**
     * 根据条件得到所有客户信息
     * @author caoxin
     * @param clientInfoCondition 查询条件
     * @createTime 2016-12-17
     * @return List 客户信息列表
     */
    public List<ClientInfo> getClientInfoList(ClientInfoCondition condition);
    
    /**
     * 根据条件得到所有客户信息数量
     * @author caoxin
     * @param clientInfo 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getClientInfoCount(ClientInfoCondition condition);
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteClientInfoById(Integer id);
    
    /**
     * 更新客户信息信息
     * @author caoxin
     * @param clientInfo 客户信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateClientInfo(ClientInfo clientInfo);
    
}
