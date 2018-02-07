package com.guoxin.module.clientAddress.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.clientAddress.condition.ClientAddressCondition;
import com.guoxin.module.clientAddress.dao.IClientAddressDao;
import com.guoxin.module.clientAddress.entity.ClientAddress;
import com.guoxin.module.clientAddress.service.IClientAddressService;

/**
 * 用户地址 Service层实现类
 * @author caoxin
 * @createTime 2016-12-17
 */
@Service("clientAddressService")
public class ClientAddressService implements IClientAddressService {
    
    @Resource
    private IClientAddressDao clientAddressDao;     //用户地址持久层
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param Integer 
     * @createTime 2016-12-17
     * @return 
     */
    public ClientAddress getClientAddressById(Integer id){
        return this.clientAddressDao.getClientAddressById(id);
    }
    
    /**
     * 添加用户地址信息
     * @author caoxin
     * @param clientAddress 用户地址实例
     * @createTime 2016-12-17
     * @return 
     */
    public int addClientAddress(ClientAddress clientAddress) {
        return this.clientAddressDao.insertClientAddress(clientAddress);
    }
    
    /**
     * 根据条件得到所有用户地址的分页列表
     * @author caoxin
     * @param clientAddressCondition 查询条件
     * @createTime 2016-12-17
     * @return PageInfo 分页对象
     */
    public PageInfo getClientAddressPageList(ClientAddressCondition condition) {
        PageInfo pageInfo = new PageInfo(condition);
        pageInfo.setTotalRows(this.clientAddressDao.getClientAddressCount(condition));
        
        if(condition.getPageNum() != null){
            if(pageInfo.getTotalRows() > 0 && condition.getPageNum() > pageInfo.getTotalPages()){
                condition.setPageNum(pageInfo.getTotalPages());
                condition.setLimitOffset();
            }
        }
        
        pageInfo.setItems(this.clientAddressDao.getClientAddressPageList(condition));
        return pageInfo;
    }
    
    /**
     * 根据条件得到所有用户地址
     * @author caoxin
     * @param clientAddressCondition 查询条件
     * @createTime 2016-12-17
     * @return List 用户地址列表
     */
    public List<ClientAddress> getClientAddressList(ClientAddressCondition condition) {
        return this.clientAddressDao.getClientAddressPageList(condition);
    }
    
    /**
     * 根据条件得到所有用户地址
     * @author caoxin
     * @param clientAddress 用户地址实例
     * @createTime 2016-12-17
     * @return List 用户地址列表
     */
    public List<ClientAddress> getClientAddressList(ClientAddress clientAddress) {
        return this.clientAddressDao.getClientAddressList(clientAddress);
    }
    
    /**
     * 根据条件得到所有用户地址数量
     * @author caoxin
     * @param clientAddress 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getClientAddressCount(ClientAddressCondition condition){
        return this.getClientAddressCount(condition);
    }
    
    /**
     * 更新用户地址信息
     * @author caoxin
     * @param clientAddress 用户地址实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateClientAddress(ClientAddress clientAddress){
        return this.clientAddressDao.updateClientAddress(clientAddress);
    }
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteClientAddressById(Integer id){
        return this.clientAddressDao.deleteClientAddressById(id);
    }
    
}
