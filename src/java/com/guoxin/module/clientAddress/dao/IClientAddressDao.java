package com.guoxin.module.clientAddress.dao;

import java.util.List;
import com.guoxin.module.clientAddress.condition.ClientAddressCondition;
import com.guoxin.module.clientAddress.entity.ClientAddress;

/**
 * 用户地址 DAO层接口
 * @author caoxin
 * @createTime 2016-12-17
 */
public interface IClientAddressDao {
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param 
     * @createTime 2016-12-17
     * @return ClientAddress
     */
    public ClientAddress getClientAddressById(Integer id);
    
    /**
     * 添加用户地址信息
     * @author caoxin
     * @param clientAddress 用户地址实例
     * @createTime 2016-12-17
     * @return 
     */
    public int insertClientAddress(ClientAddress clientAddress);
    
    /**
     * 更新用户地址信息
     * @author caoxin
     * @param clientAddress 用户地址实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateClientAddress(ClientAddress clientAddress);
    
    /**
     * 根据条件得到所有用户地址的分页列表
     * @author caoxin
     * @param clientAddressCondition 查询条件
     * @createTime 2016-12-17
     * @return List 用户地址列表
     */
    public List<ClientAddress> getClientAddressPageList(ClientAddressCondition condition);
    
    /**
     * 根据条件得到所有用户地址数量
     * @author caoxin
     * @param clientAddress 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getClientAddressCount(ClientAddressCondition condition);
    
    /**
     * 根据条件得到所有用户地址列表
     * @author caoxin
     * @param clientAddress 查询条件
     * @createTime 2016-12-17
     * @return List 用户地址列表
     */
    public List<ClientAddress> getClientAddressList(ClientAddress clientAddress);
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteClientAddressById(Integer id);
    
}
