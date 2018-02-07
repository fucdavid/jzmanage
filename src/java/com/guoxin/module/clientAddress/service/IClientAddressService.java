package com.guoxin.module.clientAddress.service;

import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.clientAddress.condition.ClientAddressCondition;
import com.guoxin.module.clientAddress.entity.ClientAddress;

/**
 * 用户地址 Service层接口
 * @author caoxin
 * @createTime 2016-12-17
 */
public interface IClientAddressService {
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param Integer 
     * @createTime 2016-12-17
     * @return 
     */
    public ClientAddress getClientAddressById(Integer id);
    
    /**
     * 添加用户地址信息
     * @author caoxin
     * @param clientAddress 用户地址实例
     * @createTime 2016-12-17
     * @return 
     */
    public int addClientAddress(ClientAddress clientAddress);
    
    /**
     * 根据条件得到所有用户地址的分页列表
     * @author caoxin
     * @param clientAddressCondition 查询条件
     * @createTime 2016-12-17
     * @return PageInfo 分页对象
     */
    public PageInfo getClientAddressPageList(ClientAddressCondition condition);
    
    /**
     * 根据条件得到所有用户地址
     * @author caoxin
     * @param clientAddress 用户地址实例
     * @createTime 2016-12-17
     * @return List 用户地址列表
     */
    public List<ClientAddress> getClientAddressList(ClientAddress clientAddress);
    
    /**
     * 根据条件得到所有用户地址
     * @author caoxin
     * @param clientAddressCondition 查询条件
     * @createTime 2016-12-17
     * @return List 用户地址列表
     */
    public List<ClientAddress> getClientAddressList(ClientAddressCondition condition);
    
    /**
     * 根据条件得到所有用户地址数量
     * @author caoxin
     * @param clientAddress 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getClientAddressCount(ClientAddressCondition condition);
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteClientAddressById(Integer id);
    
    /**
     * 更新用户地址信息
     * @author caoxin
     * @param clientAddress 用户地址实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateClientAddress(ClientAddress clientAddress);
    
}
